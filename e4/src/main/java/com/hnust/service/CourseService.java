package com.hnust.service;

import com.hnust.mapper.CourseMapper;
import com.hnust.pojo.Course;
import com.hnust.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.xml.namespace.QName;
import java.util.List;

public class CourseService {
    //
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Course> selectAll()
    {
        //调用CourseMapper.selectAll()


        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取CourseMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //调用方法

        List<Course> courses = mapper.selectAll();

        sqlSession.close();

        return courses;
    }

    public void add(Course course){
        SqlSession sqlSession = factory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        mapper.add(course);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public Course selectById(int id){
        SqlSession sqlSession = factory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        Course course = mapper.selectById(id);

        sqlSession.close();
        return course;
    }

    public void update(Course course){
        SqlSession sqlSession = factory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        mapper.update(course);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(String name){
        SqlSession sqlSession = factory.openSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        mapper.delete(name);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
