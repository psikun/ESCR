package com.escr.auth.service.impl;

import com.escr.auth.dto.request.LoginRequest;
import com.escr.auth.entity.LoginUser;
import com.escr.auth.service.LoginService;
import com.escr.auth.utils.JwtTokenUtils;
import com.escr.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author SiKun
 * @date 2023/04/13/ 15:46
 */
@Slf4j
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
        log.info(loginRequest.toString());
        // 进行用户认证
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);
            // 认证通过
            if (!Objects.isNull(authenticate)) {
                // 如果认证通过，使用userId生成jwt，并且将jwt返回
                LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
                String username = loginUser.getUsername();
                token = jwtTokenUtils.generateToken(username);
                // 将用户信息存入redis
                redisUtils.set("login:" + username, loginUser);
            }
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}",e.getMessage());
        }
        return token;
    }

    @Override
    public Boolean logout() {
        // 获取SecurityContextHolder中的用户名
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        String username = loginUser.getUsername();
        // 删除redis中的数据
        return redisUtils.delete("login:" + username);
    }
}
