package com.yawei.mapper;


import com.yawei.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> findAll();
    void delete(Integer id);
    void update(User user);
    void insert(User user);

    User findById(Integer id);
    User findByMap(Map<String,Object> param);
    User findByParams(@Param("username") String username,@Param("password") String password);
}
