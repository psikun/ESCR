package com.escr.report.service;

import com.escr.report.entity.EpidemicInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author psikun
* @description 针对表【rms_epidemic_information】的数据库操作Service
* @createDate 2023-05-06 19:50:01
*/
public interface EpidemicInformationService extends IService<EpidemicInformation> {

    EpidemicInformation getTodayInformation(String today);
}
