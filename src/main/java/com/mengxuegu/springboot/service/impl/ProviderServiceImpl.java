/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProviderServiceImpl
 * Author:   sunhao
 * Date:     2019/4/13 21:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mengxuegu.springboot.service.impl;

import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import com.mengxuegu.springboot.service.ProviderService;
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
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Override
    public List<Provider> getProviders(Provider provider) {
        return providerMapper.getProviders(provider);
    }

    @Override
    public Provider getProviderByPid(Integer pid) {
        return providerMapper.getProviderByPid(pid);
    }

    @Override
    public int addProvider(Provider provider) {
        return providerMapper.addProvider(provider);
    }

    @Override
    public int deleteProvider(Integer pid) {
        return providerMapper.deleteProvider(pid);
    }

    @Override
    public int updateProvider(Provider provider) {
        return providerMapper.updateProvider(provider);
    }
}