package com.escr.area.controller;

import com.escr.area.entity.RegionDetails;
import com.escr.area.service.RegionDetailsService;
import com.escr.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author psikun
 * @description RegionController
 * @date 2023/04/18/ 20:11
 */

@RequestMapping("/region")
@RestController()
public class RegionController {

    @Autowired
    private RegionDetailsService regionDetailsService;

    @ApiOperation("获取region集合")
    @GetMapping("list")
    public Result<List<RegionDetails>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<RegionDetails> list = regionDetailsService.list(pageNum, pageSize);
        if (!Objects.isNull(list)) {
            return Result.success(list);
        }
        return Result.failed("查询失败");
    }

    @ApiOperation("通过regionId获取region信息")
    @GetMapping("/{regionId}")
    public Result<RegionDetails> getRegionDetailById(@PathVariable("regionId") Integer regionId) {
        RegionDetails regionDetail = regionDetailsService.getById(regionId);
        if (!Objects.isNull(regionDetail)) {
            return Result.success(regionDetail);
        }
        return Result.failed();
    }

    @ApiOperation("添加region信息")
    @PostMapping("/add")
    public Result<String> add(@RequestBody RegionDetails regionDetail) {
        if (regionDetailsService.save(regionDetail)) {
            return Result.success("添加成功");
        }
        return Result.failed("添加失败");
    }

    @ApiOperation("修改region信息")
    @PutMapping("/update")
    public Result<String> update(@RequestBody RegionDetails regionDetail) {
        if (regionDetailsService.updateById(regionDetail)) {
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }

    @ApiOperation("删除指定报告")
    @DeleteMapping("/delete/{regionId}")
    public Result<String> deleteById(@PathVariable("regionId") Long regionId) {
        if (regionDetailsService.removeById(regionId)) {
            return Result.success(null, "删除成功");
        }
        return Result.failed("删除失败");
    }

    @ApiOperation("判定风险等级")
    @PostMapping("/getRiskLevel")
    public Result<String> getRiskLevel(@RequestParam(value = "address") String address) {

        String riskLevel = regionDetailsService.getRiskLevel(address).toString();
        if (!Objects.isNull(riskLevel)) {
            return Result.success(riskLevel);
        }
        return Result.failed("查找失败");
    }
}
