package com.hnust.service;

import com.hnust.mapper.UserMapper;
import com.hnust.pojo.User;
import com.hnust.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public User login(String email,String password){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(email, password);

        sqlSession.close();

        return user;
    }


    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = mapper.selectByUseremail(user.getEmail());
        if(u == null ){
            //用户名不存在
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null ;
    }
}
