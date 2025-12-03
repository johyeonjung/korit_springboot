package com.korit.springboot.controller;


import com.korit.springboot.dto.ReqFormDataDto;
import com.korit.springboot.dto.ReqJsonDto2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
//POST 요청 데이터 받는 방법 1 - Map을 통해  JSON 데이터 받는 방법
@RestController
public class RequestDataController2 {

    @PostMapping("/req/data2")
    public ResponseEntity<?> reqPost1(@RequestBody ReqJsonDto2 data) {
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/req/data3")
    public ResponseEntity<?> reqPost2(@RequestParam MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return ResponseEntity.ok().build();
    }
    @PostMapping(value = "/req/data4", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> reqPost3(@RequestPart("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return ResponseEntity.ok().build();
    }
    //파일 전송을 위해서는 요청 content type이 꼭 multipart.form-data
    @PostMapping(value = "/req/data44", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> reqPost4(ReqFormDataDto dto) {
        System.out.println(dto.getFile());
        return ResponseEntity.ok().build();
    }

    //파일 전송을 위해서는 요청 content type이 꼭 multipart.form-data
    @PostMapping(value = "/req/data5", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> reqPost5(@RequestPart("files") List<MultipartFile> files) {
        files.forEach(file -> System.out.println(file.getOriginalFilename()));
        return ResponseEntity.ok().build();
    }

    //put 요청 데이터 받는 방법 1 - JSON 데이터만 보통 사용 RequestBody 써야함
    @PutMapping("/req/data1/{id}")
    public ResponseEntity<?> reqPut1(@RequestBody ReqJsonDto2 dto) {
        System.out.println(dto);
        return ResponseEntity.ok().build();
    }
    //put 요청 데이터 받는 방법 1 - JSON 데이터만 보통 사용 RequestBody 써야함
    @PatchMapping("/req/data1/{id}")
    public ResponseEntity<?> reqPatch(@PathVariable int id, @RequestBody ReqJsonDto2 dto) {
        System.out.println(dto);
        return ResponseEntity.ok().build();
    }

    //삭제는 항상 id만 사용 (조건을 키값으로)
    @DeleteMapping("/req/data1/{id}")
    public ResponseEntity<?> reqDelete(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok().build();
    }





}

