package com.jin;

import com.jin.pojo.User;
import com.jin.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisPlusServiceTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    //用count方法查看表中记录的总条数
    public void testCount(){
        System.out.println(userService.count());
    }

    @Test
    //批量添加多条数据
    public void insertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(20+i);
            user.setName("韩立"+i);
            list.add(user);
        }
        System.out.println(userService.saveBatch(list));
    }
}
