package com.itheima;

import com.itheima.mapper.CourseMapper;
import com.itheima.mapper.SchoolMapper;
import com.itheima.pojo.Course;
import com.itheima.pojo.School;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatistest {

    @Test
    public void testselectone() throws Exception {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
//        List<course> courses = sqlSession.selectList("test.selectAll");
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = courseMapper.selectone(2);

        System.out.println(courses);

        sqlSession.close();
    }

    @Test
    public void testselectcs() throws Exception {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
//        List<course> courses = sqlSession.selectList("test.selectAll");
        SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
        int sid = schoolMapper.selectcsid("计算机学院");

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = courseMapper.selectcs(sid);

        System.out.println(courses);

        sqlSession.close();
    }

    @Test
    public void testupdate() throws Exception {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
//        List<course> courses = sqlSession.selectList("test.selectAll");

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
/*        Course course = courseMapper.selectone(4);
        int id = course.getHour() + 8;
        course.setHour(id);

        System.out.println(id);*/
        int count = courseMapper.update();

        System.out.println(count);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void tesadd() throws Exception {
        String names= "大数据存储";
        int hours=32;
        int schools =1;

        Course course = new Course();
        course.setHour(hours);
        course.setName(names);
        course.setSid(schools);


        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
//        List<course> courses = sqlSession.selectList("test.selectAll");

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        courseMapper.add(course);
        int id = course.getId();
        System.out.println(id);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void tesAll() throws Exception {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
//        List<course> courses = sqlSession.selectList("test.selectAll");

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses= courseMapper.selectAll();

        System.out.println(courses);

        SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
        List<School> schools = schoolMapper.selectAll();

        System.out.println(schools);

        sqlSession.close();
    }
}
