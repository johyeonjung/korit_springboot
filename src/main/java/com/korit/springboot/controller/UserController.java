package com.korit.springboot.controller;

import com.korit.springboot.config.BeanConfig;
import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 1
// ResponseBody -> 데이터 리턴
// Controller -> 뷰 응답
// RestController -> 데이터 응답
@RestController
@RequiredArgsConstructor
public class UserController {
//    @Autowired
    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<?> create( @RequestBody CreateUserReqDto dto) {
//        userService.createUser(dto);
        userService.duplicatedUsername(dto.getUsername());
        int createdUserId= userService.createUser(dto);

        return ResponseEntity.ok(Map.of("createdUserId",createdUserId));
    }

}
