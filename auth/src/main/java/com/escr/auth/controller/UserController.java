package com.escr.auth.controller;

import com.escr.auth.entity.User;
import com.escr.auth.service.impl.UserServiceImpl;
import com.escr.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author psikun
 * @description UserController
 * @date 2023/05/17/ 20:46
 */

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @ApiOperation("获取用户集合")
    @GetMapping("list")
    public Result<List<User>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<User> list = userService.list(pageNum, pageSize);
        if (!Objects.isNull(list)) {
            return Result.success(list);
        }
        return Result.failed("查询失败");
    }

}
