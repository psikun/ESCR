package com.escr.report.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.report.entity.EpidemicInformation;
import com.escr.report.service.EpidemicInformationService;
import com.escr.report.mapper.EpidemicInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author psikun
 * @description 针对表【rms_epidemic_information】的数据库操作Service实现
 * @createDate 2023-05-06 19:50:01
 */
@Service
public class EpidemicInformationServiceImpl extends ServiceImpl<EpidemicInformationMapper, EpidemicInformation>
        implements EpidemicInformationService {


    @Autowired
    private EpidemicInformationMapper empidemicInformationMapper;

    @Override
    public EpidemicInformation getTodayInformation(String today) {

        QueryWrapper<EpidemicInformation> queryWrap = new QueryWrapper<>();
        queryWrap.eq("date", today);
        EpidemicInformation epidemicInformation = empidemicInformationMapper.selectOne(queryWrap);
        return epidemicInformation;
    }
}




