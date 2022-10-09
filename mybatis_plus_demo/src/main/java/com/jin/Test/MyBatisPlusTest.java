package com.jin.Test;

import com.jin.mapper.UserMapper;
import com.jin.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MyBatisPlusTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::print);
    }

}
