package com.escr.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.escr.report.entity.ReportDetails;
import com.escr.report.model.dto.request.SearchReportRequest;

import java.util.List;

/**
 * The interface Report details service.
 *
 * @author psikun
 * @description 针对表 【rms_report_details】的数据库操作Service
 * @createDate 2023 -04-17 12:34:48
 */
public interface ReportDetailsService extends IService<ReportDetails> {

    IPage<ReportDetails> list(Integer pageNum, Integer pageSize);

    IPage<ReportDetails> search(SearchReportRequest searchReportRequest);
}
