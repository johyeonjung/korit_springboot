package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatedException;
import com.korit.springboot.mapper.UserMapper;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public int createUser(CreateUserReqDto dto) {
        UserEntity userEntity = dto.toEntity();
        userMapper.insert(userEntity);
        return userEntity.getUserId();
    }
    public void duplicatedUsername (String username) {
        UserEntity foundUser = userMapper.findUserByUsername(username);
//        if(foundUser != null) {
//            MethodParameter methodParameter = null;
//            BindingResult bindingResult = new BeanPropertyBindingResult(foundUser,"");
//            FieldError fieldError = new FieldError("username", "username","이미 사용중인 이름입니다");
//            bindingResult.addError(fieldError);
//            throw new M0ethodArgumentNotValidException(methodParameter,bindingResult);
//        }
        if (foundUser != null) {
            throw new DuplicatedException("username", "이미 존재하는 사용자 이름입니다");
        }
    }
}
