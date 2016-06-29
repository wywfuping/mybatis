package com.yawei.test;


import com.yawei.mapper.TopicMapper;
import com.yawei.pojo.Topic;
import com.yawei.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicTestCase {

    private Logger logger = LoggerFactory.getLogger(TopicTestCase.class);

    @Test
    public void testFindById(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);

        Topic topic = topicMapper.findById(1);

        logger.debug("{}",topic);
        logger.debug("username:{} email:{} avatar:{}",topic.getForumUser().getUsername(),topic.getForumUser().getEmail(),topic.getForumUser().getAvatar());
        logger.debug("nodename:{}",topic.getNode().getNodename());

        sqlSession.close();
    }
}
