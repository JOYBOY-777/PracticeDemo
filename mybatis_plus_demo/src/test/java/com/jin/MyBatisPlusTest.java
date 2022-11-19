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
        System.out.println(userMapper.deleteById(7L));
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

    @Test
    //测试update方法,传入一个实体类，只需要把里面的Id设置好，就可以根据这个id进行修改
    public void testUpdate(){
        User user = new User();
        user.setId(7l);
        user.setName("石穿空");
        user.setAge(15151);
        user.setEmail("zzzzz.com");
        System.out.println(userMapper.updateById(user));
    }

    @Test
    //测试查询方法
    public void testSelect(){
        //根据id查询
        System.out.println(userMapper.selectById(7l).toString());
        System.out.println("==================");
        //根据多个id查询
        userMapper.selectBatchIds(Arrays.asList(1l,5l,7l,8l)).forEach(System.out::println);
    }

    @Test
    //根据map集合进行查询
    public void testMapSelect(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","石穿空");
        map.put("age","15151");
        userMapper.selectByMap(map).forEach(System.out::println);
        //查询所有数据
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    //自定义功能写xml进行查询
    public void testSelectMapById(){
        Map<String, Object> map = userMapper.selectMapById(7l);
        System.out.println(map);
    }
}
