package com.escr.area.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author psikun
 * @TableName ams_region_details
 */
@TableName(value = "ams_region_details")
@Data
public class RegionDetails implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long regionId;


    /**
     * 详细地址
     */
    private String address;


    /**
     * 风险等级(低风险地区-0，中风险地区-1，高风险地区-2)
     */
    private Integer riskLevel;

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
     * 死亡人数
     */
    private Integer death;

    /**
     * 当地风险政策
     */
    private String policy;

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