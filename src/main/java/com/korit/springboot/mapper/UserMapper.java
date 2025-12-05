package com.korit.springboot.mapper;

import com.korit.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int insert(UserEntity userEntity);
    UserEntity findUserByUsername(@Param("username") String username);
}
