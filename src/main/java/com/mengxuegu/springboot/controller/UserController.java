/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   sunhao
 * Date:     2019/4/14 10:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author sunhao
 * @create 2019/4/14
 * @since 1.0.0
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getusers(User user, Map<String,Object> map){
        List<User> users = userService.getUsers(user);
        map.put("users",users);
        map.put("username",user.getUsername());
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String view(@PathVariable("id") Integer id,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map){
        User user = userService.getUserById(id);
        map.put("user",user);
        logger.info("查看供应商详情，类型：" + type);
        return "user/" + type;
    }

    @PutMapping("/user")
    public String update(User user){
        userService.updateUser(user);
        logger.info("供应商修改："+user.toString());
        return "redirect:users";
    }

    @GetMapping("/user")
    public String toAdd(Map<String,Object> map){
        logger.info("供应商-去添加页面");
        return "user/add";
    }

    @PostMapping("/user")
    public String add(User user){
        userService.addUser(user);
        logger.info("供应商-添加供应商："+user.getId());
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        logger.info("供应商-删除供应商："+ id);
        return "redirect:/users";
    }
}