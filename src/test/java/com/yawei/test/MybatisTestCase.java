package com.yawei.test;


import com.yawei.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MybatisTestCase {
    private Logger logger = LoggerFactory.getLogger(MybatisTestCase.class);

    @Test
    public void testFindOne() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = sqlSession.selectOne("com.yawei.mapper.UserMapper.findById", 1);
            logger.debug("{}", user);
            sqlSession.close();
            Assert.assertNotNull(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindAll() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            List<User> userList = sqlSession.selectList("com.yawei.mapper.UserMapper.findAll");

            for(User user:userList) {
                logger.debug("{}", user);
            }
            sqlSession.close();
            Assert.assertEquals(4, userList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInsert() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = new User();
            user.setUsername("马云");
            user.setAddress("杭州");
            user.setPassword("123456");
            sqlSession.insert("com.yawei.mapper.UserMapper.insert", user);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testUpdate() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();


            User user = sqlSession.selectOne("com.yawei.mapper.UserMapper.findById", 6);
            user.setUsername("王健林");
            user.setAddress("四川");
            user.setPassword("5555555");
            sqlSession.update("com.yawei.mapper.UserMapper.update", user);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDelete() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            User user = sqlSession.selectOne("com.yawei.mapper.UserMapper.findById", 2);
            sqlSession.delete("com.yawei.mapper.UserMapper.delete", user);

            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
