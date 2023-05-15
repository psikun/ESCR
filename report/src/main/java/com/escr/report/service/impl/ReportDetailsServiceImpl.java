package com.escr.report.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.escr.report.entity.ReportDetails;
import com.escr.report.mapper.ReportDetailsMapper;
import com.escr.report.model.dto.SearchReportRequest;
import com.escr.report.service.ReportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public List<ReportDetails> search(SearchReportRequest searchReportRequest) {
        QueryWrapper<ReportDetails> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(searchReportRequest.getReportId())) {
            wrapper.eq("report_id", searchReportRequest.getReportId());
        }
        if (searchReportRequest.getName() != "" && !Objects.isNull(searchReportRequest.getName())) {
            wrapper.eq("name", searchReportRequest.getName());
        }
        if (!Objects.isNull(searchReportRequest.getSourceRiskLevel())) {
            wrapper.eq("source_risk_level", searchReportRequest.getSourceRiskLevel());
        }
        if (!Objects.isNull(searchReportRequest.getNucleicAcid())) {
            wrapper.eq("nucleic_acid", searchReportRequest.getNucleicAcid());
        }
        if (!Objects.isNull(searchReportRequest.getVaccinationQuantity())) {
            wrapper.eq("vaccination_quantity", searchReportRequest.getVaccinationQuantity());
        }
        if (!Objects.isNull(searchReportRequest.getStatus())) {
            wrapper.eq("status", searchReportRequest.getStatus());
        }
        List<ReportDetails> searchResult = reportDetailsMapper.selectList(wrapper);
        return searchResult;
    }
}




