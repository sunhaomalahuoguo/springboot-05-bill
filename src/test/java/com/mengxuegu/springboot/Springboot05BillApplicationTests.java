package com.mengxuegu.springboot;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05BillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;
    @Autowired
    BillMapper billMapper;
    @Test
    public void contextLoads() {
        /*List<Provider> providerByPid = providerMapper.getProviders(new Provider());
        System.out.println(providerByPid.toString());*/
        Bill bill = billMapper.getBillByBid(1);
        System.out.println(bill.toString());
    }

}
