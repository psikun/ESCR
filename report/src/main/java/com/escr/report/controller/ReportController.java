package com.escr.report.controller;

import com.escr.common.entity.Result;
import com.escr.report.entity.ReportDetails;
import com.escr.report.service.impl.ReportDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author psikun
 */
@RestController
public class ReportController {

    @Autowired
    private ReportDetailsServiceImpl reportDetailsService;

    @ApiOperation("获取report集合")
    @GetMapping("list")
    public Result<List<ReportDetails>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<ReportDetails> list = reportDetailsService.list(pageNum, pageSize);
        if (!Objects.isNull(list)) {
            return Result.success(list);
        }
        return Result.failed("查询失败");
    }

    @ApiOperation("通过reportId获取report信息")
    @GetMapping("/{reportId}")
    public Result<ReportDetails> getReportDetailById(@PathVariable("reportId") Integer reportId) {
        ReportDetails reportDetail = reportDetailsService.getById(reportId);
        if (!Objects.isNull(reportDetail)) {
            return Result.success(reportDetail);
        }
        return Result.failed();
    }

    @ApiOperation("添加report报告")
    @PostMapping("/add")
    public Result<String> add(@RequestBody ReportDetails reportDetail) {
        if (reportDetailsService.save(reportDetail)) {
            return Result.success("添加成功");
        }
        return Result.failed("添加失败");
    }

    @ApiOperation("修改report报告")
    @PutMapping("/update")
    public Result<String> update(@RequestBody ReportDetails reportDetail) {
        if (reportDetailsService.updateById(reportDetail)) {
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }

    @ApiOperation("删除指定报告")
    @DeleteMapping("/{reportId}")
    public Result<String> deleteById(@PathVariable("reportId") Long reportId) {
        if (reportDetailsService.removeById(reportId)) {
            return Result.success(null, "删除成功");
        }
        return Result.failed("删除失败");
    }
}
