package com.escr.report.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.report.entity.ReportDetails;
import com.escr.report.mapper.ReportDetailsMapper;
import com.escr.report.service.ReportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psikun
 * @description 针对表【rms_report_details】的数据库操作Service实现
 * @createDate 2023-04-17 12:34:48
 */
@Service
public class ReportDetailsServiceImpl extends ServiceImpl<ReportDetailsMapper, ReportDetails>
        implements ReportDetailsService {

    @Autowired
    private ReportDetailsMapper reportDetailsMapper;

    @Override
    public List<ReportDetails> list(Integer pageNum, Integer pageSize) {
        Page<ReportDetails> page = new Page<>(pageNum, pageSize);
        IPage<ReportDetails> userPage = reportDetailsMapper.selectPage(page, null);
        return userPage.getRecords();
    }
}




