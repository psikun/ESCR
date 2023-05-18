package com.escr.auth.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.auth.entity.User;
import com.escr.auth.mapper.UserMapper;
import com.escr.auth.model.dto.UserRequest;
import com.escr.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public IPage<User> list(Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        IPage<User> userPage = userMapper.selectPage(page, null);
        return userPage;
    }

    @Override
    public IPage<User> search(UserRequest userRequest) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if (!Objects.isNull(userRequest.getId())) {
            wrapper.eq("id", userRequest.getId());
        }

        if (!Objects.isNull(userRequest.getUserType())) {
            wrapper.eq("user_type", userRequest.getUserType());
        }
        if (!Objects.isNull(userRequest.getStatus())) {
            wrapper.eq("status", userRequest.getStatus());
        }

        Page<User> page = new Page<>(userRequest.getPageNum(), userRequest.getPageSize());
        return userMapper.selectPage(page, wrapper);
    }

}




