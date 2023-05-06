package com.escr.area.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.escr.area.entity.CommunityDetails;

import java.util.List;

/**
* @author psikun
* @description 针对表【ams_community_details】的数据库操作Service
* @createDate 2023-05-06 19:26:33
*/
public interface CommunityDetailsService extends IService<CommunityDetails> {
    List<CommunityDetails> list(Integer pageNum, Integer pageSize);
}
