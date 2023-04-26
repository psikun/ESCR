package com.escr.rabbitmq.feign;

import com.escr.common.entity.Result;
import com.escr.rabbitmq.vo.ReportRequestVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Report feign.
 *
 * @author psikun
 * @description ReportFeign
 * @date 2023 /04/26/ 20:28
 */
@FeignClient(name = "report")
public interface ReportFeign {

    /**
     * Add by client result.
     *
     * @param reportRequestVO the report request vo
     * @return the result
     */
    @PostMapping("report/add")
    Result<String> addByClient(@RequestBody ReportRequestVO reportRequestVO);
}
