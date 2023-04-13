package com.escr.auth.service;

import com.escr.auth.dto.request.LoginRequest;

/**
 * @author SiKun
 * @date 2023/04/13/ 15:45
 */

public interface LoginService {
    /**
     * Login string.
     *
     * @param loginRequest the login request
     * @return the string
     */
    String login(LoginRequest loginRequest);
}
