package com.escr.report.controller;

import cn.hutool.core.date.DateUtil;
import com.escr.common.entity.Result;
import com.escr.report.entity.EpidemicInformation;
import com.escr.report.service.impl.EpidemicInformationServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author psikun
 */
@RequestMapping("/information")
@RestController
public class EpidemicInformationController {

    @Autowired
    private EpidemicInformationServiceImpl epidemicInformationService;

    @ApiOperation("获取今日疫情数据")
    @GetMapping("/today")
    public Result<EpidemicInformation> getTodayInformation() {
        String today = DateUtil.today();
        EpidemicInformation todayInformation = epidemicInformationService.getTodayInformation(today);
        return Result.success(todayInformation);
    }

    @ApiOperation("获取一周疫情数据")
    @PostMapping("/week")
    public Result<List<EpidemicInformation>> getWeekInformation(@RequestBody List<String> week) {
        ArrayList<EpidemicInformation> epidemicInformation = new ArrayList<>();
        for (String day : week) {
            EpidemicInformation todayInformation = epidemicInformationService.getTodayInformation(day);
            epidemicInformation.add(todayInformation);
        }
        return Result.success(epidemicInformation);
    }


    @ApiOperation("通过id获取疫情信息")
    @GetMapping("/{id}")
    public Result<EpidemicInformation> getReportDetailById(@PathVariable("id") Integer id) {
        EpidemicInformation epidemicInformation = epidemicInformationService.getById(id);
        if (!Objects.isNull(epidemicInformation)) {
            return Result.success(epidemicInformation);
        }
        return Result.failed();
    }

    @ApiOperation("添加疫情信息")
    @PostMapping("/add")
    public Result<String> add(@RequestBody EpidemicInformation epidemicInformation) {
        if (epidemicInformationService.save(epidemicInformation)) {
            return Result.success("添加成功");
        }
        return Result.failed("添加失败");
    }

    @ApiOperation("修改疫情信息")
    @PutMapping("/update")
    public Result<String> update(@RequestBody EpidemicInformation epidemicInformation) {
        if (epidemicInformationService.updateById(epidemicInformation)) {
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }

    @ApiOperation("删除指定信息")
    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable("id") Long id) {
        if (epidemicInformationService.removeById(id)) {
            return Result.success(null, "删除成功");
        }
        return Result.failed("删除失败");
    }
}
