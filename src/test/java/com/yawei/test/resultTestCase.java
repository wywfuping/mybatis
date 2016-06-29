package com.yawei.test;


import com.yawei.mapper.ResultMapper;
import com.yawei.pojo.Result;
import com.yawei.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultTestCase {
    private Logger logger = LoggerFactory.getLogger(ResultTestCase.class);

    @Test
    public void testFindById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ResultMapper resultMapper = sqlSession.getMapper(ResultMapper.class);

        Result result = resultMapper.findById(1);
        logger.debug("{}",result);
        logger.debug("username:{} address:{} password:{}",result.getUser().getUsername(),result.getUser().getAddress(),result.getUser().getPassword());
        logger.debug("subjectname:{} classhour:{}",result.getSubject().getName(),result.getSubject().getClasshour());

        sqlSession.close();

    }
}
