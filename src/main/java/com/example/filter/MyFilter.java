package com.example.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebFilter(urlPatterns = "/css/*")
@Slf4j
@WebListener
public class MyFilter implements Filter {

    /**
     * 项目初始化
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("项目初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter启动");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * 请求销毁时
     */
    @Override
    public void destroy() {
        log.info("请求销毁");
    }
}
