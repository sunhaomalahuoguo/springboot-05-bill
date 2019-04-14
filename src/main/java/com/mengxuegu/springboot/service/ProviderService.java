package com.mengxuegu.springboot.service;

import com.mengxuegu.springboot.entities.Provider;

import java.util.List;

public interface ProviderService {
    //列表查询
    public List<Provider> getProviders(Provider provider);
    //根据主键查询
    public Provider getProviderByPid(Integer pid);
    //增
    public int addProvider(Provider provider);
    //删
    public int deleteProvider(Integer pid);
    //改
    public int updateProvider(Provider provider);
}
