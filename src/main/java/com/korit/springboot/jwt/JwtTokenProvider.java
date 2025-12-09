package com.korit.springboot.jwt;

import com.korit.springboot.entity.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final SecretKey key;
    public JwtTokenProvider(@Value("${jwt.secret}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createAccessToken(UserEntity userEntity) {
        Date now = new Date();
        long expiredTime = now.getTime() + (1000l * 60l * 60l * 24l);
        Date expiredDate = new Date(expiredTime);

        return Jwts.builder()
                .subject("서버 토큰")
                .issuer("code1218")
                .issuedAt(new Date())
                .expiration(expiredDate)  //필수
                .claim("userId", userEntity.getUserId()) //필수
                .signWith(key, SignatureAlgorithm.HS256) //필수
                .compact();
    }
    //유효한지만 체크
    public boolean validateToken(String token) {
        try {
            JwtParser jwtParser = Jwts.parser()
                    .setSigningKey(key)
                    .build();
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public int getUserId(String token) {
        return (int) Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getPayload()
                .get("userId");
    }














}
