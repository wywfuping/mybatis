package com.yawei.test;


import com.google.common.collect.Maps;
import com.yawei.mapper.UserMapper;
import com.yawei.pojo.User;
import com.yawei.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class MybatisInterfaceTestCase {
    private Logger logger = LoggerFactory.getLogger(MybatisInterfaceTestCase.class);

    @Test
    public void testFindByMap(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = Maps.newHashMap();

        map.put("username","马云");
        map.put("password","123456");

        User user = userMapper.findByMap(map);
        logger.debug("{}",user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindByParams(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByParams("马云","123456");
        logger.debug("{}",user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.findAll();

        for(User user:userList){
            logger.debug("{}",user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindById(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user= userMapper.findById(1);

        logger.debug("{}",user);
        sqlSession.close();
        Assert.assertNotNull(user);
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.delete(16);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(1);
        user.setUsername("李彦宏");
        user.setAddress("山西");
        user.setPassword("123456");

        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }
}