package com.mengxuegu.springboot.service;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.ex.BillEx;

import java.util.List;


public interface BillService {
    public BillEx getBillByBid(Integer bid);

    public int addBill(Bill bill);

    public List<BillEx> getBills(Bill bill);

    public int deleteBill(Integer bid);

    public int updateBill(Bill bill);
}
