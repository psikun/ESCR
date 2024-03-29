package com.escr.area;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author psikun
 */
@SpringBootApplication(scanBasePackages = {"com.escr.area", "com.escr.common"})
@EnableDiscoveryClient
@MapperScan("com.escr.area.mapper")
@EnableFeignClients
public class AreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AreaApplication.class, args);
    }

}
