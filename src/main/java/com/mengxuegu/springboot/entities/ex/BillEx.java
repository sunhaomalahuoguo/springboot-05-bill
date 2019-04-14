/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BillEx
 * Author:   sunhao
 * Date:     2019/4/13 22:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mengxuegu.springboot.entities.ex;

import com.mengxuegu.springboot.entities.Bill;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author sunhao
 * @create 2019/4/13
 * @since 1.0.0
 */
public class BillEx extends Bill {

    //供应商名称
    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}