package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    int insert(@Param("product_name") String product_name,
               @Param("size") String size,
               @Param("price") int price);
}
