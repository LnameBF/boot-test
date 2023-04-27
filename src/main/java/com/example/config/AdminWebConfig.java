package com.example.config;

import com.example.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1. 编写一个拦截器实现
 * 2.拦截器注册到容器中
 * 3.指定拦截规则注意拦截规则
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginInterceptor())
                    //配置拦截那些路径 注意，配置拦截/**（拦截所有请求） 会导致静态资源也被拦截
                    .addPathPatterns("/**")
                    //不拦截那些路径
                    .excludePathPatterns("/","/login","/static/css/**","/static/js/**","/static/fonts/**","/static/images/**");
    }
}
