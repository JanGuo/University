package com.janguo.carsystem.config;

import com.janguo.carsystem.vo.index.FindIndex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class AllDateBaseKeyNumberConfig {

    @Resource
    FindIndex findIndex;

    @Bean
    public void getCustomerIndex() {

        // TODO
        // 测试是否单例， index是否线程安全
        findIndex.getIndex();
    }
}
