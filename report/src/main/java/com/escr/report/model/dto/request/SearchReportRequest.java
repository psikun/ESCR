package com.escr.report.model.dto.request;

import lombok.Data;

/**
 * @Author psikun
 * @Description SearchReportRequest
 * @Date 2023/05/11/ 9:59
 */

@Data
public class SearchReportRequest {

    private Long reportId;

    /**
     * 报备人员姓名
     */
    private String name;


    /**
     * 是否有48小时核酸记录
     */
    private Boolean nucleicAcid;


    /**
     * 疫苗接种数量
     */
    private Integer vaccinationQuantity;


    /**
     * 始发地风险等级
     */
    private Integer sourceRiskLevel;


    /**
     * 报备状态(0:待审核、1:已审核、2:已驳回)
     */
    private Integer status;

    private Integer pageNum;

    private Integer pageSize;

}
