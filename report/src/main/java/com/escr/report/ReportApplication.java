package com.escr.report;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author psikun
 */

@SpringBootApplication(scanBasePackages = {"com.escr.report", "com.escr.common"})
@EnableDiscoveryClient
@MapperScan("com.escr.report.mapper")
public class ReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class, args);
    }

}
