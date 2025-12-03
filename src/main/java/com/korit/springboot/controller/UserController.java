package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 1
// ResponseBody -> 데이터 리턴
// Controller -> 뷰 응답
// RestController -> 데이터 응답
@RestController
public class UserController {

    private String username = "test12";
    private String password = "1234";

    @GetMapping("/users2")
    public List userInfo() {
        List users = new ArrayList();
        users.add(username);
        users.add(password);
        return users;
    }

//    @GetMapping("/users")
//    public Map<String,String> getUsers(HttpServletResponse response) {
//        response.setStatus(400);
//        response.setContentType("application/json");
//        return Map.of("username", username,"password", password);
//    }

    @GetMapping("/users")
    public ResponseEntity<Map<String,String>> getUsers(HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("username", username,"password", password));
    }


}
