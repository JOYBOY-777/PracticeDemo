package com.jin;

import com.jin.mapper.UserMapper;
import com.jin.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    //添加方法传入一个对象保存，返回值是受影响的行数
    public void testInsert(){
        User user = new User();
        user.setName("历飞雨");
        user.setEmail("xxx.@xx.com");
        user.setAge(23);
        System.out.println(userMapper.insert(user));
    }

    @Test
    //测试直接传入id，根据id进行字段的删除
    public void testDelete(){
        System.out.println(userMapper.deleteById(6L));
    }
    @Test
    //测试根据map删除
    public void testMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","Tom");
        map.put("age",28);
        //删除name为Tom并且age为28的这条记录，并且传入一个map，前面是条件后面是值
        System.out.println(userMapper.deleteByMap(map));
    }

    @Test
    //传入一个实体类，但是还是根据id删除，只要把id赋值以后
    public void testDeleteById(){
        User user = new User();
        user.setId(888l);
        user.setName("历飞雨");
        user.setEmail("xxx.@xx.com");
        user.setAge(23);
        System.out.println(userMapper.deleteById(user));
    }

    @Test
    //批量删除,传入一个id的集合
    public void testDeleteByIds(){
        System.out.println(userMapper.deleteBatchIds(Arrays.asList(2l, 4l)));
    }

}
