package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.ex.BillEx;

import java.util.List;

/**
 * @Auther: 梦学谷
 */
//@Mapper 或 @MapperScan
public interface BillMapper {

    BillEx getBillByBid(Integer bid);

    int addBill(Bill bill);

    List<BillEx> getBills(Bill bill);

    int deleteBill(Integer bid);

    int updateBill(Bill bill);
}
