package com.itheima.mapper;

import com.itheima.pojo.Course;

import java.util.List;

public interface CourseMapper {

        List<Course> selectAll();

        List<Course> selectone(int id);

        List<Course> selectcs(int sid);

        void add(Course course);

        int update();
}
