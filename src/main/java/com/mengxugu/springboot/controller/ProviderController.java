package com.mengxugu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProviderController {

    @GetMapping("/providers")
    public String list(){
        return "provider/list";
    }
}
