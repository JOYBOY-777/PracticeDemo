package com.jin;

import com.jin.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    }
}
