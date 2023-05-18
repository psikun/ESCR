package com.escr.area.controller;

import com.escr.area.entity.CommunityDetails;
import com.escr.area.service.CommunityDetailsService;
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

@RequestMapping("/community")
@RestController
public class CommunityController {

    @Autowired
    private CommunityDetailsService communityDetailsService;

    @ApiOperation("获取community集合")
    @GetMapping("list")
    public Result<List<CommunityDetails>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize) {
        List<CommunityDetails> list = communityDetailsService.list(pageNum, pageSize);
        if (!Objects.isNull(list)) {
            return Result.success(list);
        }
        return Result.failed("查询失败");
    }

    @ApiOperation("通过id获取community信息")
    @GetMapping("/{id}")
    public Result<CommunityDetails> getRegionDetailById(@PathVariable("id") Integer id) {
        CommunityDetails communityDetails = communityDetailsService.getById(id);
        if (!Objects.isNull(communityDetails)) {
            return Result.success(communityDetails);
        }
        return Result.failed();
    }

    @ApiOperation("添加community报告")
    @PostMapping("/add")
    public Result<String> add(@RequestBody CommunityDetails communityDetails) {
        if (communityDetailsService.save(communityDetails)) {
            return Result.success("添加成功");
        }
        return Result.failed("添加失败");
    }

    @ApiOperation("修改community报告")
    @PutMapping("/update")
    public Result<String> update(@RequestBody CommunityDetails communityDetails) {
        if (communityDetailsService.updateById(communityDetails)) {
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }

    @ApiOperation("删除指定报告")
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteById(@PathVariable("id") Long id) {
        if (communityDetailsService.removeById(id)) {
            return Result.success(null, "删除成功");
        }
        return Result.failed("删除失败");
    }

    @ApiOperation("通过用户名获取community信息")
    @PostMapping("/getCommunityByUsername")
    public Result<CommunityDetails> getCommunityByUsername(@RequestBody String username) {
        CommunityDetails community = communityDetailsService.getCommunityByUsername(username);
        return Result.success(community);
    }
}
