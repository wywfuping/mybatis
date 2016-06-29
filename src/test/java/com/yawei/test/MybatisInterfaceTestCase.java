package com.yawei.test;


import com.google.common.collect.Lists;
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
    public void testBatchSave() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = Lists.newArrayList();
        userList.add(new User("雷军", "china", "77777"));
        userList.add(new User("刘强东", "china", "888888"));

        userMapper.batchSave(userList);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testFindByPage() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findByPage(0, 3);

        for (User user : userList) {
            logger.debug("{}", user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindByQueryParam() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = Maps.newHashMap();

        map.put("username", "马云");
        map.put("password", "123456");
        map.put("address", "四川");

        List<User> userList = userMapper.findByQueryParam(map);
        logger.debug("{}", userList);
        sqlSession.close();
    }

    @Test
    public void testFindByMap() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = Maps.newHashMap();

        map.put("username", "马云");
        map.put("password", "123456");

        User user = userMapper.findByMap(map);
        logger.debug("{}", user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindByParams() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByParams("马云", "123456");
        logger.debug("{}", user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            logger.debug("{}", user);
        }

        sqlSession.close();
    }

    @Test
    public void testFindByIds() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> idList = Lists.newArrayList(19, 20, 21);
        List<User> userList = userMapper.findByIds(idList);

        logger.debug("{}", userList);
        sqlSession.close();
    }

    //一级缓存和二级缓存演示
    @Test
    public void testFindById() {
        //二级缓存
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(1);
        logger.debug("{}", user);
        sqlSession.close();
        //-------------------------------------------------
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);

        User user1 = userMapper1.findById(1);
        logger.debug("{}", user1);
        sqlSession1.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.delete(16);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
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
