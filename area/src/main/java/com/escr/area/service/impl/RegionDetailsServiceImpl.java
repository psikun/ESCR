package com.escr.area.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.area.entity.RegionDetails;
import com.escr.area.model.dto.SearchRegionRequest;
import com.escr.area.service.RegionDetailsService;
import com.escr.area.mapper.RegionDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public IPage<RegionDetails> list(Integer pageNum, Integer pageSize) {
        Page<RegionDetails> page = new Page<>(pageNum, pageSize);
        IPage<RegionDetails> regionPage = regionDetailsMapper.selectPage(page, null);
        return regionPage;
    }

    @Override
    public Integer getRiskLevel(String address) {
        QueryWrapper<RegionDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("address", address);
        RegionDetails regionDetails = regionDetailsMapper.selectOne(queryWrapper);
        return regionDetails.getRiskLevel();
    }

    @Override
    public IPage<RegionDetails> search(SearchRegionRequest searchRegionRequest) {

        QueryWrapper<RegionDetails> wrapper = new QueryWrapper<>();

        if (!Objects.isNull(searchRegionRequest.getRegionId())) {
            wrapper.eq("region_id", searchRegionRequest.getRegionId());
        }

        if (!Objects.isNull(searchRegionRequest.getRiskLevel())) {
            wrapper.eq("risk_level", searchRegionRequest.getRiskLevel());
        }

        Page<RegionDetails> page = new Page<>(searchRegionRequest.getPageNum(), searchRegionRequest.getPageSize());
        IPage<RegionDetails> list = regionDetailsMapper.selectPage(page,wrapper);
        return list;
    }
}




