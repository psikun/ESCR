package com.escr.auth.controller;

import com.escr.auth.dto.request.LoginRequest;
import com.escr.auth.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.escr.common.entity.Result;

import java.util.HashMap;

/**
 * @author psikun
 * @Description LoginController
 * @date 2023/02/20/ 12:46
 */

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result<HashMap<String, String>> login(@RequestBody LoginRequest loginRequest) {

        String token = loginService.login(loginRequest);
        if (!token.isEmpty()) {
            HashMap<String, String> map = new HashMap<>(1);
            map.put("token", token);
            return Result.success(map, "登陆成功");
        } else {
            return Result.unauthorized("用户名或密码错误");
        }
    }

    @ApiOperation("注销接口")
    @GetMapping("/logoff")
    public Result<String> logout() {
        if (loginService.logout()) {
            return Result.success("退出成功");
        } else {
            return Result.failed("退出失败");
        }
    }


}
