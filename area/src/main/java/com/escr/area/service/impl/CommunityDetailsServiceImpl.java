package com.escr.area.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.area.entity.CommunityDetails;
import com.escr.area.mapper.CommunityDetailsMapper;
import com.escr.area.service.CommunityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psikun
 * @description 针对表【ams_community_details】的数据库操作Service实现
 * @createDate 2023-05-06 19:26:33
 */
@Service
public class CommunityDetailsServiceImpl extends ServiceImpl<CommunityDetailsMapper, CommunityDetails>
        implements CommunityDetailsService {
    @Autowired
    private CommunityDetailsMapper communityDetailsMapper;

    @Override
    public List<CommunityDetails> list(Integer pageNum, Integer pageSize) {


        Page<CommunityDetails> page = new Page<>(pageNum, pageSize);
        IPage<CommunityDetails> userPage = communityDetailsMapper.selectPage(page, null);
        return userPage.getRecords();
    }
}




