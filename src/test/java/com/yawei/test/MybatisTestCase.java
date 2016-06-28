package com.yawei.test;


import com.yawei.pojo.User;
import com.yawei.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MybatisTestCase {
    private Logger logger = LoggerFactory.getLogger(MybatisTestCase.class);



    @Test
    public void testFindOne() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            User user = sqlSession.selectOne("com.yawei.mapper.UserMapper.findById", 1);
            logger.debug("{}", user);
            sqlSession.close();
            Assert.assertNotNull(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testFindAll() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            List<User> userList = sqlSession.selectList("com.yawei.mapper.UserMapper.findAll");

            for (User user : userList) {
                logger.debug("{}", user);
            }
            sqlSession.close();
            Assert.assertEquals(4, userList.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testInsert() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            User user = new User();
            user.setUsername("马云");
            user.setAddress("杭州");
            user.setPassword("123456");
            sqlSession.insert("com.yawei.mapper.UserMapper.insert", user);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testUpdate() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            User user = sqlSession.selectOne("com.yawei.mapper.UserMapper.findById", 6);
            user.setUsername("王健林");
            user.setAddress("四川");
            user.setPassword("5555555");
            sqlSession.update("com.yawei.mapper.UserMapper.update", user);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDelete() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();

            User user = sqlSession.selectOne("com.yawei.mapper.UserMapper.findById", 2);
            sqlSession.delete("com.yawei.mapper.UserMapper.delete", user);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
