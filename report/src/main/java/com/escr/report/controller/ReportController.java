package com.escr.report.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.escr.common.entity.Result;
import com.escr.report.entity.ReportDetails;
import com.escr.report.feign.AreaFeign;
import com.escr.report.model.dto.SearchReportRequest;
import com.escr.report.service.impl.ReportDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author psikun
 */
@RestController
public class ReportController {

    @Autowired
    private ReportDetailsServiceImpl reportDetailsService;

    @Autowired
    private AreaFeign areaFeign;

    @ApiOperation("获取report集合")
    @GetMapping("list")
    public Result<List<ReportDetails>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<ReportDetails> list = reportDetailsService.list(pageNum, pageSize);
//        for (ReportDetails report : list) {
//            report.setRiskLevel(areaFeign.riskLevel(report.getSource()).getData());
//        }
        if (!Objects.isNull(list)) {
            return Result.success(list);
        }
        return Result.failed("查询失败");
    }

    @ApiOperation("通过reportId获取report信息")
    @GetMapping("/{reportId}")
    public Result<ReportDetails> getReportDetailById(@PathVariable("reportId") Integer reportId) {
        ReportDetails reportDetail = reportDetailsService.getById(reportId);
//        reportDetail.setRiskLevel(areaFeign.riskLevel(reportDetail.getSource()).getData());
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


    @ApiOperation("搜索报告")
    @PostMapping("/search")
    public Result<List<ReportDetails>> search(@RequestBody SearchReportRequest searchReportRequest) {
        List<ReportDetails> list = reportDetailsService.search(searchReportRequest);
        if (!Objects.isNull(list)) {
            return Result.success(list, "查询成功");
        }
        return Result.failed("查询失败");
    }

    //导出文件接口
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        //从数据库查询出所有的数据
        List<ReportDetails> list = reportDetailsService.list();

        //hutools
        ExcelWriter writer = ExcelUtil.getWriter(true);

        //  writer.writeHeadRow(Arrays.asList("序号", "姓名", "身份证", "手机号", "始发地", "健康信息", "目的地", "交通方式", "交通详情", "报备原因", "48小时核酸检测", "风险等级", "疫苗接种数量", "报备时间", "更新时间", "到达时间", "出发时间", "报备状态", "是否删除"));

        writer.write(list, true);

        //设置浏览器响应的格式
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String fileName = URLEncoder.encode("报备信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
}
