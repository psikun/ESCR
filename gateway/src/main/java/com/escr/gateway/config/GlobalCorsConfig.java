package com.escr.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author psikun
 * @description 全局跨域配置,前端从网关进行调用时需要配置
 * @date 2023/04/14/ 18:48
 */

@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }

}