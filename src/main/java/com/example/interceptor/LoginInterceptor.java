package com.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查
 * 1、配置拦截器要拦截那些请求
 * 2. 把这些配置放在容器中
 * 3.
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 执行目标方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录检查逻辑
        log.info(request.getRequestURI());
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("LoginUser");
        if (loginUser != null) {
            //放行
            return true;
        }
        //否则拦截 重定向到登录页面
        request.setAttribute("msg","用户未登录");
        //转发
        request.getRequestDispatcher("/").forward(request,response);
            return false;
    }
    /**
     * 执行目标方法之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    /**
     * 登录检查之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
