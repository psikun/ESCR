package com.escr.auth.handler;

import cn.hutool.json.JSONUtil;
import com.escr.common.entity.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author psikun
 * @description 认证失败异常处理,当未登录或者token失效访问接口时，自定义的返回结果
 * @date 2023/04/14/ 18:15
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // 处理异常
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(Result.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
