package com.mengxugu.springboot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null){
            //从session中能取出登录用户，说明登录过，直接放行
            logger.info("拦截器校验-用户已经登录");
            return true;
        }
        //为登录,转发到登陆页面
        request.setAttribute("msg","没有权限，请先登录！");
        logger.info("拦截器校验-用户未登录，没有权限,请先登录");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
