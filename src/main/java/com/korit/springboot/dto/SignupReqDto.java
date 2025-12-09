package com.korit.springboot.dto;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import com.korit.springboot.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Data
public class SignupReqDto {

    //정규표현식(문자열 형식 검사)
    @Pattern(regexp = "^[a-z0-9_-]{5,20}$", message = "아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9])[A-Za-z0-9^A-Za-z0-9\\W]{8,16}$",
            message = "비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.")
    private String password;
    @Pattern(regexp = "^[가-힣]{2,6}$", message = "이름: 2~6자의 한글을 사용해주세요")
    private String name;
    @Email
    @NotBlank
    private String email;

    public UserEntity toEntity(BCryptPasswordEncoder passwordEncoder) {
        return UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .build();
    }

}
