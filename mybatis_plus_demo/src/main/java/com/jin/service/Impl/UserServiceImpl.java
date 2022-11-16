package com.jin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jin.mapper.UserMapper;
import com.jin.pojo.User;
import com.jin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
