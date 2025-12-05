package com.korit.springboot.mapper;

import com.korit.springboot.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        UserEntity userEntity = UserEntity.builder()
                .username("test")
                .password("1234")
                .name("김준일")
                .email("test@gmail.com")
                .build();
        int successCount = userMapper.insert(userEntity);
        System.out.println(successCount);
    }

    @Test
    void findUserByUsernameTest() {
        UserEntity foundUser = userMapper.findUserByUsername("test1234");
        System.out.println(foundUser);
    }
}
