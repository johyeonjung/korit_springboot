package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudyMapper {
    int insert(@Param("name") String name, @Param("age") int age);
    List<String> findAllName();
    List<Map<String, Object>> findAll();
}

