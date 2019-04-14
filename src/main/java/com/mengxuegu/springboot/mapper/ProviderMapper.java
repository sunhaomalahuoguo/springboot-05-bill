package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Provider;

import java.util.List;

public interface ProviderMapper {
    //列表查询
    List<Provider> getProviders(Provider provider);
    //根据主键查询
    Provider getProviderByPid(Integer pid);
    //增
    int addProvider(Provider provider);
    //删
    int deleteProvider(Integer pid);
    //改
    int updateProvider(Provider provider);
}
