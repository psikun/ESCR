package com.escr.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Auth application.
 *
 * @author psikun
 */
@SpringBootApplication(scanBasePackages = {"com.escr.auth", "com.escr.common"})
@MapperScan("com.escr.auth.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
