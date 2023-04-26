package com.escr.rabbitmq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author psikun
 * @description ReportRequestVO
 * @date 2023/04/26/ 20:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequestVO {
    /**
     * 报备人员姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 出发地
     */
    private String source;

    /**
     * 健康状况
     */
    private String healthy;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 交通方式
     */
    private String transportation;

    /**
     * 交通详情
     */
    private String trafficDetails;

    /**
     * 返回理由
     */
    private String reason;

    /**
     * 是否有48小时核酸记录
     */
    private Boolean nucleicAcid;

    /**
     * 疫苗接种数量
     */
    private Integer vaccinationQuantity;
}
