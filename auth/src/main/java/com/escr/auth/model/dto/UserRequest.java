package com.escr.auth.model.dto;

import lombok.Data;

/**
 * @Author psikun
 * @Description UserRequest
 * @Date 2023/05/18/ 11:24
 */
@Data
public class UserRequest {
    private String id;
    private Integer userType;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
