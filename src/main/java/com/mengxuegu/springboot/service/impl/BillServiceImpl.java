/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BillServiceImpl
 * Author:   sunhao
 * Date:     2019/4/13 21:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mengxuegu.springboot.service.impl;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.ex.BillEx;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author sunhao
 * @create 2019/4/13
 * @since 1.0.0
 */
@Transactional
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;
    @Override
    public BillEx getBillByBid(Integer bid) {
        return billMapper.getBillByBid(bid);
    }

    @Override
    public int addBill(Bill bill) {
        return billMapper.addBill(bill);
    }

    @Override
    public List<BillEx> getBills(Bill bill) {
        return billMapper.getBills(bill);
    }

    @Override
    public int deleteBill(Integer bid) {
        return billMapper.deleteBill(bid);
    }

    @Override
    public int updateBill(Bill bill) {
        return billMapper.updateBill(bill);
    }
}