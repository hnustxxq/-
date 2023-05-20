package com.hnust;

import com.hnust.mapper.CourseMapper;
import com.hnust.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ex1 {

    //1. 查询 id=2 的课程信息
    @Test
    public  void testSelectById() throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();


        //3,获取mapper接口的代理对象
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        //4.执行方法
        int id=2;
        Course course = courseMapper.selectById(id);
        System.out.println(course);


        //5.释放资源
        sqlSession.close();
    }

//    2. 查询出所有计算机学院开设的课程信息
@Test
public  void testSelectAllInCS() throws IOException {
    //1.加载mybatis的核心配置文件，获取SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //2.获取sqlSession对象
    SqlSession sqlSession=sqlSessionFactory.openSession();


    //3,获取mapper接口的代理对象
    CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

    //4.执行方法
    String name="计算机学院";
    List<Course> courses = courseMapper.selectByName(name);
    System.out.println(courses);


    //5.释放资源
    sqlSession.close();
}

//3. 将 id=4 这⻔课程的课时数修改为 32+8=40
    @Test
    public  void testUpdateById() throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();


        //3,获取mapper接口的代理对象
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        //4.执行方法
        int id=4;
        courseMapper.updateById(id);

        //提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

//4. 插⼊⼀条新的课程记录： names=”⼤数据存储“，hours=32，schools =1
    @Test
    public  void testAdd() throws IOException {
        //接收参数
        String name="⼤数据存储";
        int hours=32;
        int sid=1;

        //封装对象
        Course course=new Course();
        course.setHours(hours);
        course.setName(name);
        course.setSid(sid);

        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();


        //3,获取mapper接口的代理对象
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        //4.执行方法

        courseMapper.add(course);

        //提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

//5. 输出所有的学院开设的课程信息
    @Test
    public  void testSelectAll() throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();


        //3,获取mapper接口的代理对象
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        //4.执行方法
        List<Course> courses = courseMapper.selectAll();
        System.out.println(courses);


        //5.释放资源
        sqlSession.close();
    }

}
