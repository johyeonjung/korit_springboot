package com.korit.springboot.service;

import com.korit.springboot.dto.SigninReqDto;
import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatedException;
import com.korit.springboot.jwt.JwtTokenProvider;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//자동 객체 주입
@RequiredArgsConstructor
public class AuthService {
    //service 는 컴포넌트라서 toEntity에 넘겨주면 조립 가능 DTO에 바로 쓸수없음
    private final BCryptPasswordEncoder passwordEncoder;
    //이거 쓰지말래
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;


    //service -> mapper(entity)
    public void SignupService(SignupReqDto dto) {
        UserEntity userEntity = dto.toEntity(passwordEncoder);
        userMapper.insert(userEntity);

    }
    public void duplicatedUsername (String username) {
        UserEntity foundUser = userMapper.findUserByUsername(username);
        if (foundUser != null) {
            throw new DuplicatedException("username", "이미 존재하는 사용자 이름입니다.");
        }
    }

    public String signin(SigninReqDto dto) {
        final String username = dto.getUsername();
        final String password = dto.getPassword();
        final String defaultMessage = "사용자 정보를 확인하세요";
        UserEntity foundUser = userMapper.findUserByUsername(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException(defaultMessage);
        }
        if (!passwordEncoder.matches(password, foundUser.getPassword())) {
            throw new BadCredentialsException(defaultMessage);
        }
        //토큰 생성
        String accessToken = jwtTokenProvider.createAccessToken(foundUser);

        return accessToken;
    }
}
