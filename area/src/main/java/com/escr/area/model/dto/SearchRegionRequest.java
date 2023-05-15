package com.escr.area.model.dto;

import lombok.Data;

/**
 * @Author psikun
 * @Description SearchRegionRequest
 * @Date 2023/05/15/ 16:05
 */

@Data
public class SearchRegionRequest {

    private Long regionId;

    private Integer riskLevel;
}
