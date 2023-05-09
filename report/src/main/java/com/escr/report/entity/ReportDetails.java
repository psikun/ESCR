package com.escr.report.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @author psikun
 * @TableName rms_report_details
 */
@TableName(value = "rms_report_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDetails implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long reportId;

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

    @TableField(exist = false)
    private Integer riskLevel = 0;

    /**
     * 疫苗接种数量
     */
    private Integer vaccinationQuantity;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    /**
     * 到达时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arrivalTime;


    /**
     * 出发时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date departureTime;


    /**
     * 报备状态(0:待审核、1:已审核、2:已驳回)
     */
    private Date status;

    /**
     * 逻辑删除
     */
    private Boolean deleted;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}