package com.escr.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.escr.auth.entity.User;
import com.escr.auth.model.dto.UserRequest;
import com.escr.auth.service.impl.UserServiceImpl;
import com.escr.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result<IPage<User>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        IPage<User> list = userService.list(pageNum, pageSize);
        if (!Objects.isNull(list)) {
            return Result.success(list);
        }
        return Result.failed("查询失败");
    }


    @ApiOperation("搜索用户")
    @PostMapping("/search")
    public Result<IPage<User>> search(@RequestBody UserRequest userRequest) {
        IPage<User> list = userService.search(userRequest);
        if (!Objects.isNull(list)) {
            return Result.success(list, "查询成功");
        }
        return Result.failed("查询失败");
    }

}
