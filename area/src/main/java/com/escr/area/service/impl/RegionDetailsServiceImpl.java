package com.escr.area.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.area.entity.RegionDetails;
import com.escr.area.service.RegionDetailsService;
import com.escr.area.mapper.RegionDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psikun
 * @description 针对表【ams_region_details】的数据库操作Service实现
 * @createDate 2023-04-17 12:57:10
 */
@Service
public class RegionDetailsServiceImpl extends ServiceImpl<RegionDetailsMapper, RegionDetails>
        implements RegionDetailsService {

    @Autowired
    private RegionDetailsMapper regionDetailsMapper;

    @Override
    public List<RegionDetails> list(Integer pageNum, Integer pageSize) {
        Page<RegionDetails> page = new Page<>(pageNum, pageSize);
        IPage<RegionDetails> userPage = regionDetailsMapper.selectPage(page, null);
        return userPage.getRecords();
    }

    @Override
    public String getRiskLevel(String address) {
        QueryWrapper<RegionDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("address", address);
        RegionDetails regionDetails = regionDetailsMapper.selectOne(queryWrapper);
        return regionDetails.getRiskLevel();
    }
}




