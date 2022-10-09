package com.jin;

import com.jin.mapper.UserMapper;
import com.jin.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyBatisPlusTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
