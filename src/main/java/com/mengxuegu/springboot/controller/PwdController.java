/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PwdController
 * Author:   sunhao
 * Date:     2019/4/14 13:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author sunhao
 * @create 2019/4/14
 * @since 1.0.0
 */
@Controller
public class PwdController {

    @Autowired
    UserService userService;

    @GetMapping("/password")
    public String toPassword(){
        return "main/password";
    }

    @ResponseBody
    @GetMapping("/checkpwd/{oldPassword}")
    public Boolean checkPwd(@PathVariable("oldPassword") String oldPassword, HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        if (!StringUtils.isEmpty(oldPassword) && oldPassword.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    @PostMapping("/updatePwd")
    public String updatePwd(String password,HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        user.setPassword(password);
        session.setAttribute("loginUser",user);
        userService.updateUser(user);
        return "redirect:/logout";
    }
}