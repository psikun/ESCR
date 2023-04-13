package com.escr.auth.controller;

import com.escr.auth.dto.request.LoginRequest;
import com.escr.auth.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.escr.common.result.Result;

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
            return Result.failed("登录失败");
        }
    }
}
