package com.escr.auth.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.auth.entity.User;
import com.escr.auth.mapper.UserMapper;
import com.escr.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psikun
 * @description 针对表【ums_user(用户信息表)】的数据库操作Service实现
 * @createDate 2023-02-19 19:46:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        IPage<User> userPage = userMapper.selectPage(page, null);
        return userPage.getRecords();
    }

}




