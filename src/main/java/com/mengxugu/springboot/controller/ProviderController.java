package com.mengxugu.springboot.controller;

import com.mengxugu.springboot.dao.ProviderDao;
import com.mengxugu.springboot.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class ProviderController {

    @Autowired
    private ProviderDao providerDao;
    @GetMapping("/providers")
    public String list(Map<String,Object> map){
        Collection<Provider> providers = providerDao.getAll();
        map.put("providers",providers);
        return "provider/list";
    }

}
