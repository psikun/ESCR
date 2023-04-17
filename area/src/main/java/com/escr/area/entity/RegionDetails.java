package com.escr.area.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author psikun
 * @TableName ams_region_details
 */
@TableName(value ="ams_region_details")
@Data
public class RegionDetails implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long regionId;

    /**
     * 省级单位
     */
    private String province;

    /**
     * 市级单位
     */
    private String city;

    /**
     * 县级单位
     */
    private String county;

    /**
     * 镇级单位
     */
    private String town;

    /**
     * 村级单位
     */
    private String village;

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
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RegionDetails other = (RegionDetails) that;
        return (this.getRegionId() == null ? other.getRegionId() == null : this.getRegionId().equals(other.getRegionId()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getTown() == null ? other.getTown() == null : this.getTown().equals(other.getTown()))
            && (this.getVillage() == null ? other.getVillage() == null : this.getVillage().equals(other.getVillage()))
            && (this.getRiskLevel() == null ? other.getRiskLevel() == null : this.getRiskLevel().equals(other.getRiskLevel()))
            && (this.getNewInfection() == null ? other.getNewInfection() == null : this.getNewInfection().equals(other.getNewInfection()))
            && (this.getExistingInfection() == null ? other.getExistingInfection() == null : this.getExistingInfection().equals(other.getExistingInfection()))
            && (this.getRecovered() == null ? other.getRecovered() == null : this.getRecovered().equals(other.getRecovered()))
            && (this.getDeath() == null ? other.getDeath() == null : this.getDeath().equals(other.getDeath()))
            && (this.getPolicy() == null ? other.getPolicy() == null : this.getPolicy().equals(other.getPolicy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegionId() == null) ? 0 : getRegionId().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getTown() == null) ? 0 : getTown().hashCode());
        result = prime * result + ((getVillage() == null) ? 0 : getVillage().hashCode());
        result = prime * result + ((getRiskLevel() == null) ? 0 : getRiskLevel().hashCode());
        result = prime * result + ((getNewInfection() == null) ? 0 : getNewInfection().hashCode());
        result = prime * result + ((getExistingInfection() == null) ? 0 : getExistingInfection().hashCode());
        result = prime * result + ((getRecovered() == null) ? 0 : getRecovered().hashCode());
        result = prime * result + ((getDeath() == null) ? 0 : getDeath().hashCode());
        result = prime * result + ((getPolicy() == null) ? 0 : getPolicy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", regionId=").append(regionId);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", town=").append(town);
        sb.append(", village=").append(village);
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", newInfection=").append(newInfection);
        sb.append(", existingInfection=").append(existingInfection);
        sb.append(", recovered=").append(recovered);
        sb.append(", death=").append(death);
        sb.append(", policy=").append(policy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}