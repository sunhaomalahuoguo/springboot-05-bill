/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BillController
 * Author:   sunhao
 * Date:     2019/4/13 22:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.ex.BillEx;
import com.mengxuegu.springboot.service.BillService;
import com.mengxuegu.springboot.service.ProviderService;
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
 * @create 2019/4/13
 * @since 1.0.0
 */
@Controller
public class BillController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BillService billService;
    @Autowired
    ProviderService providerService;

    @GetMapping("/bills")
    public String getBills(Bill bill, Map<String,Object> map){
        List<BillEx> bills = billService.getBills(bill);
        map.put("bills",bills);
        List<Provider> providers = providerService.getProviders(null);
        map.put("providers",providers);
        map.put("pid",bill.getPid());
        map.put("pay",bill.getPay());
        map.put("billName",bill.getBillName());
//        aaaaaa
        return "bill/list";
    }

    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map){
        BillEx bill = billService.getBillByBid(bid);
        map.put("bill",bill);
        if(!"view".equals(type)){
            List<Provider> providers = providerService.getProviders(null);
            map.put("providers",providers);
        }
        logger.info("查看供应商详情，类型：" + type);
        return "bill/" + type;
    }

    @PutMapping("/bill")
    public String update(Bill bill){
        billService.updateBill(bill);
        logger.info("供应商修改："+bill.toString());
        return "redirect:bills";
    }

    @GetMapping("/bill")
    public String toAdd(Map<String,Object> map){
        logger.info("供应商-去添加页面");
        List<Provider> providers = providerService.getProviders(null);
        map.put("providers",providers);
        return "bill/add";
    }

    @PostMapping("/bill")
    public String add(Bill bill){
        billService.addBill(bill);
        logger.info("供应商-添加供应商："+bill.getPid());
        return "redirect:/bills";
    }

    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid){
        billService.deleteBill(bid);
        logger.info("供应商-删除供应商："+ bid);
        return "redirect:/bills";
    }

}