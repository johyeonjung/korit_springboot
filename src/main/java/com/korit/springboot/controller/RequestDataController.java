package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqDataDto6;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestDataController {

    //get요청 파라미터 받는 방법 1
    @GetMapping("/req/data1")
    public ResponseEntity<Map<String,String>> reqGet1(HttpServletRequest request) {
        String name = request.getParameter("a");
        int age = Integer.parseInt(request.getParameter("n"));
        System.out.println("data1 : " + name);
        //ok안에 값을 넣어줘야함 또는 build
        return ResponseEntity.ok().build();
    }

    //get요청 파라미터 받는 방법 2
    @GetMapping("/req/data2")
    public ResponseEntity<Map<String,String>> reqGet2(@RequestParam("a") String name, @RequestParam("b") int age) {
        //ok안에 값을 넣어줘야함 또는 build
        System.out.println(name);
        System.out.println(age);
        return ResponseEntity.ok().build();
    }
    //get요청 파라미터 받는 방법 3 - 변수명과 파라미터 영이 일치하면 @RequestParam의 이름을 생략할 수 있다
    @GetMapping("/req/data3")
    public ResponseEntity<Map<String,String>> reqGet3(@RequestParam String name, @RequestParam int age) {
        //ok안에 값을 넣어줘야함 또는 build
        System.out.println(name);
        System.out.println(age);
        return ResponseEntity.ok().build();
    }

    //get요청 파라미터 받는 방법 4 - 해당 파라미터를 필수 항목으로 설정할 수 있다 (기본값 True)
    //int는 null이 못들어가기 때문에 Integer로 해야 함
    //정수 자료형의 파라미터가 필수가 아닐 때 Integer 자료형을 사용해야한다. (null 처리 가능하기 때문)
    @GetMapping("/req/data4")
    public ResponseEntity<Map<String,String>> reqGet4(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        //ok안에 값을 넣어줘야함 또는 build
        System.out.println(name);
        System.out.println(age);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/req/data5")
    public ResponseEntity<Map<String,String>> reqGet5(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam String address,
            @RequestParam String phone) {
        //ok안에 값을 넣어줘야함 또는 build
        System.out.println(name);
        System.out.println(age);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/req/data6")
    public ResponseEntity<Map<String,String>> reqGet6(ReqDataDto6 dto6) {
        //ok안에 값을 넣어줘야함 또는 build
        System.out.println(dto6.getName());
        System.out.println(dto6.getAge());
        return ResponseEntity.ok().build();
    }
    //get요청 파라미터 받는 방법 7 - 주소에서 값 가져오기
    @GetMapping("/req/{path}/data7/{id}")
    public ResponseEntity<Map<String,String>> reqGet7(
            @PathVariable int id,
            @PathVariable String path,
            ReqDataDto6 dto6) {
        //ok안에 값을 넣어줘야함 또는 build
        System.out.println(dto6.getName());
        System.out.println(dto6.getAge());
        return ResponseEntity.ok().build();
    }
}
