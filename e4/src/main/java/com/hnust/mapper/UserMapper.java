package com.hnust.mapper;

import com.hnust.pojo.User;
import com.hnust.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    @Select("select * from user where email = #{email} and password = #{password}")
    User select(@Param("email") String email,@Param("password")  String password);


    @Select("select * from user where email = #{email}")
    User selectByUseremail(String email);


    @Insert("insert into user values(null,#{email},#{password})")
    void add(User user);
}
