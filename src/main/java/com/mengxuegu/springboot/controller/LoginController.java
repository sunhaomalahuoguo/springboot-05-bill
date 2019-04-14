package com.mengxuegu.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "111".equals(password)){
            //登录成功，跳转到主页面
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        //登录失败，跳转到登陆页面
        map.put("msg","登录失败，用户名或密码错误");
        return "main/login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        session.invalidate();
        logger.info("用户登出");
        return "main/login";
    }
}
