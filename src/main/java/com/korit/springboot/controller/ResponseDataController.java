package com.korit.springboot.controller;

import com.korit.springboot.dto.RespJsonDto;
import com.korit.springboot.dto.RespJsonDto2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ResponseDataController {

//    @CrossOrigin("http://localhost:5173")
    //응답 데이터 - 문자열
    @GetMapping("/resp/data1")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("문자열 응답");
    }

    //응답 데이터 - Map
    @GetMapping("/resp/data2")
    public ResponseEntity<Map<String,Object>> getMap() {
        return ResponseEntity.ok(Map.of("key1","value1", "key2","value2"));
    }

    //응답 데이터 - List
    @GetMapping("/resp/data3")
    public ResponseEntity<List<?>> getList() {
        return ResponseEntity.ok(List.of("a","b", "c"));
    }

    //응답 데이터 - 객체
    @GetMapping("/resp/data4")
    public ResponseEntity<RespJsonDto> getObject() {
        RespJsonDto dto = new RespJsonDto();
        dto.setName("김준일");
        dto.setEmail("abc@naver.com");
        dto.setRespJsonDto2(new RespJsonDto2());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/resp/data5")
    public ResponseEntity<Resource> download(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ filename + "\"")
                .body(resource);

    }

    @GetMapping("/resp/data6")
    public ResponseEntity<Resource> downloadUTF8(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);

        //다운로드를 하려면 attachment로
        String contentDisposition = ContentDisposition.builder("attachment")
                //인코딩해야함
                .filename(filename, StandardCharsets.UTF_8)
                .build().toString();

        return ResponseEntity.ok()
                //파일 응답 전송 때 사용되는 컨텐츠의 타입
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);

    }
}
