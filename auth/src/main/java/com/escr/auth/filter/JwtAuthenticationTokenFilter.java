package com.escr.auth.filter;

import com.escr.auth.entity.LoginUser;
import com.escr.auth.utils.JwtTokenUtils;
import com.escr.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author psikun
 * @description Jwt认证过滤器
 * @date 2023/04/13/ 18:38
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            // token非空，放行
            filterChain.doFilter(request, response);
            return;
        }

        // 解析token
        String userNameFromToken = jwtTokenUtils.getUserNameFromToken(token);

        // 从redis中获取用户信息
        LoginUser loginUser = (LoginUser) redisUtils.get("login:" + userNameFromToken);

        // 存入SecurityContextHolder
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        // TODO 获取权限信息封装到Authentication
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
