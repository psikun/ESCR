package com.escr.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.escr.auth.entity.LoginUser;
import com.escr.auth.mapper.MenuMapper;
import com.escr.auth.mapper.UserMapper;
import com.escr.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author psikun
 * @Description 重写UserDetailsServiceImpl
 * @date 2023/02/19/ 19:52
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        // 数据封装成UserDetails类
        // 查询对应权限信息
        List<String> list = menuMapper.selectPermissionsByUserId(user.getId());
        return new LoginUser(user, list);
    }
}
