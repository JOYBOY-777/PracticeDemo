package com.jin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user")
public class User {
    //TableId就是将对应的字段指定为主键
    //里面的value属性用于指定主键的字段（如果实体类中的属性与数据库中不一致的情况下，那么就要要求value中的值一致）
    //设置自动递增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
