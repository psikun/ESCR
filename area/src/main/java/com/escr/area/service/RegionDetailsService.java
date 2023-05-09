package com.escr.area.service;

import com.escr.area.entity.RegionDetails;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author psikun
* @description 针对表【ams_region_details】的数据库操作Service
* @createDate 2023-04-17 12:57:10
*/
public interface RegionDetailsService extends IService<RegionDetails> {
    List<RegionDetails> list(Integer pageNum, Integer pageSize);

    String getRiskLevel(String address);
}
