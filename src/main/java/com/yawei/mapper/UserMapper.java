package com.yawei.mapper;


import com.yawei.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    void batchSave(List<User> userList);
    List<User> findByIds(List<Integer> idList);
    List<User> findAll();
    List<User> findByQueryParam(Map<String,Object> queryParam);
    List<User> findByPage(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    void delete(Integer id);
    void update(User user);
    void insert(User user);

    User findById(Integer id);
    User findByMap(Map<String,Object> param);
    User findByParams(@Param("username") String username,@Param("password") String password);
}
