package com.escr.area.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.escr.area.entity.RegionDetails;
import com.escr.area.model.dto.SearchRegionRequest;
import com.escr.area.service.RegionDetailsService;
import com.escr.common.entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
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
    public Result<IPage<RegionDetails>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        IPage<RegionDetails> list = regionDetailsService.list(pageNum, pageSize);
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

    @ApiOperation("删除指定地区")
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

    @ApiOperation("搜索风险地区")
    @PostMapping("/search")
    public Result<IPage<RegionDetails>> search(@RequestBody SearchRegionRequest searchRegionRequest) {
        IPage<RegionDetails> list = regionDetailsService.search(searchRegionRequest);
        if (!Objects.isNull(list)) {
            return Result.success(list, "查询成功");
        }
        return Result.failed("查询失败");
    }


    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        //从数据库查询出所有的数据
        List<RegionDetails> list = regionDetailsService.list();

        //hutools
        ExcelWriter writer = ExcelUtil.getWriter(true);

        //  writer.writeHeadRow(Arrays.asList("序号", "姓名", "身份证", "手机号", "始发地", "健康信息", "目的地", "交通方式", "交通详情", "报备原因", "48小时核酸检测", "风险等级", "疫苗接种数量", "报备时间", "更新时间", "到达时间", "出发时间", "报备状态", "是否删除"));

        writer.write(list, true);

        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("风险地区", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
}
