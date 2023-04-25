package com.example.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源映射
 */
@Component
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //这样配置表示浏览器中携带static的所有请求都会映射道resources目录下的static目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
       // registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/static/templates/table");
    }
}
