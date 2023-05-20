package com.hnust.mapper;

import com.hnust.pojo.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {


//    傻鸟mybatisx插件会爆红，但是没错

    //@Select("select * from c_course")
    List<Course> selectAll();

   //@Select("select * from c_course where id=#{id}")
   Course selectById(int id);

//    @Select("select c_course.id,name,hours,sid from c_course,s_school  where sid=s_school.id and s_school.schoolname=#{schoolname}")
    List<Course> selectByName(String schoolname);

//    @Update("update c_course set hours=40 where id=#{id}")
//    void updateById(int id);

//实验一
//    void updateById(int id);

    void update(Course course);

    void delete(String name);

//    @Insert("insert into c_course(name, hours, sid) values (#{name},#{hours},#{sid})")
    void add(Course course);

    Course selectByCname(String name);
}
