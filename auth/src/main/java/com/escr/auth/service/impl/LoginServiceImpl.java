package com.escr.auth.service.impl;

import com.escr.auth.dto.request.LoginRequest;
import com.escr.auth.entity.LoginUser;
import com.escr.auth.service.LoginService;
import com.escr.auth.utils.JwtTokenUtils;
import com.escr.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author SiKun
 * @date 2023/04/13/ 15:46
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    private String token = "";


    @Override
    public String login(LoginRequest loginRequest) {
        // 进行用户认证
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        // 如果认证未通过，给出对应提示
        if (!Objects.isNull(authenticate)) {
            // 如果认证通过，使用userId生成jwt，并且将jwt返回
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            String username = loginUser.getUsername();
            token = jwtTokenUtils.generateToken(username);
            // 将用户信息存入redis
            redisUtils.set("login:" + username, loginUser);
        }
        return token;
    }
}
