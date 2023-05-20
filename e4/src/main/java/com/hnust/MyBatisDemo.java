package com.hnust;

import com.hnust.mapper.CourseMapper;
import com.hnust.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {

    public static void main(String[] args) throws Exception {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqLSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.执行sql

//        List<Course> courses=sqlSession.selectList("test.selectAll");
//        System.out.println(courses);

        //3.获取mapper代理对象
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses=courseMapper.selectAll();

        System.out.println(courses);
        //4.释放资源
        sqlSession.close();

    }

}
