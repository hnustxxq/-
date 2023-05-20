package com.itheima;

import com.itheima.mapper.CourseMapper;
import com.itheima.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 5. 推荐的建库脚本：
 * ⼯具类
 */
public class MyBatisUtils {

    public static void main(String[] args) throws IOException {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
//        List<course> courses = sqlSession.selectList("test.selectAll");
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = courseMapper.selectAll();

        System.out.println(courses);

        sqlSession.close();
    }

}