package com.mengxugu.springboot.controller;

import com.mengxugu.springboot.dao.ProviderDao;
import com.mengxugu.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private ProviderDao providerDao;
    @GetMapping("/providers")
    public String list(Map<String,Object> map,@RequestParam(value = "providerName",required = false) String providerName){
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers",providers);
        map.put("providerName",providerName);
        logger.info("查看供应商列表，入参：" + providerName);
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map){
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
        logger.info("查看供应商详情，类型：" + type);
        return "provider/" + type;
    }

    @PutMapping("/provider")
    public String update(Provider provider){
        providerDao.save(provider);
        logger.info("供应商修改："+provider.toString());
        return "redirect:providers";
    }

    @GetMapping("/provider")
    public String toAdd(){
        logger.info("供应商-去添加页面");
        return "provider/add";
    }

    @PostMapping("/provider")
    public String add(Provider provider){
        providerDao.save(provider);
        logger.info("供应商-添加供应商："+provider.getPid());
        return "redirect:/providers";
    }

    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid){
        int i = 1/0;
        providerDao.delete(pid);
        logger.info("供应商-删除供应商："+ pid);
        return "redirect:/providers";
    }
}
