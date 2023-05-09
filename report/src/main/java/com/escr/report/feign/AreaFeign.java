package com.escr.report.feign;

import com.escr.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.plaf.synth.Region;

/**
 * @Author psikun
 * @Description AreaFeign
 * @Date 2023/05/09/ 10:14
 */
@FeignClient(name = "area")
public interface AreaFeign {

    @PostMapping("/area/getRiskLevel")
    Result<Integer> riskLevel(@RequestParam String address);
}
