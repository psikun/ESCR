package com.escr.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author psikun
 * @TableName rms_epidemic_information
 */
@TableName(value ="rms_epidemic_information")
@Data
public class EpidemicInformation implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 新增感染数量
     */
    private Integer newInfection;

    /**
     * 现存感染数量
     */
    private Integer existingInfection;

    /**
     * 已痊愈人数
     */
    private Integer recovered;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    /**
     * 死亡人数
     */
    private Integer death;

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
     * 逻辑删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}