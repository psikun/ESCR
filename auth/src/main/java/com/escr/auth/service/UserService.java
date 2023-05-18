package com.escr.auth.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.escr.auth.entity.User;
import com.escr.auth.model.dto.UserRequest;

import java.util.List;

/**
 * @author psikun
 * @description 针对表【ums_user(用户信息表)】的数据库操作Service
 * @createDate 2023-02-19 19:46:47
 */
public interface UserService extends IService<User> {

    IPage<User> list(Integer pageNum, Integer pageSize);

    IPage<User> search(UserRequest userRequest);
}
