package com.itheima.mapper;

import com.itheima.pojo.School;

import java.util.List;

public interface SchoolMapper {
    int selectcsid(String name);

    List<School> selectAll();
}
