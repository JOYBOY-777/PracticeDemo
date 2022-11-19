package com.jin.pojo;

import com.baomidou.mybatisplus.annotation.*;
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
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //此注解声明这个属性对应在表中的字段是什么，不写报错
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;
}
