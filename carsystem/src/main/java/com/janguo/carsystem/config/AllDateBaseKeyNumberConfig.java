package com.janguo.carsystem.config;

import com.janguo.carsystem.domain.IndexKeyNumber;
import com.janguo.carsystem.vo.index.FindIndex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class AllDateBaseKeyNumberConfig {

    @Bean
    public IndexKeyNumber getAllKeyNumber() {

        IndexKeyNumber keyNumber = new IndexKeyNumber();

        keyNumber.setCustomerEntityIndex("1");
        keyNumber.setDepartmentEntityIndex("1");
        keyNumber.setOrderDetailEntityIndex("1");
        keyNumber.setOrderEntityIndex("1");
        keyNumber.setProductEntityIndex("1");
        keyNumber.setSaleAccountListEntityIndex("1");
        keyNumber.setStaffEntityIndex("1");
        keyNumber.setStockAccountListEntityIndex("1");
        keyNumber.setStockDetailEntityIndex("1");
        keyNumber.setStorageEntityIndex("1");
        keyNumber.setSupplierEntityIndex("1");
        keyNumber.setStockEntityIndex("1");
        return keyNumber;
    }


    @Resource
    FindIndex findIndex;

    @Bean
    public void getCustomerIndex() {

        // TODO
        // 测试是否单例， index是否线程安全
        findIndex.getIndex();

    }
}
