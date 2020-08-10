package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.CustomerEntity;
import com.janguo.carsystem.service.CustomerService;
import com.janguo.carsystem.vo.index.FindIndex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    void testGetAllCustomer() {
        System.out.println(customerService.getAllCustomer());
    }


    @Test
    void testGetCustomerById() {
        System.out.println(customerService.getCustomerById("1"));
    }

    @Test
    void testGetAllCosByAdd() {
        System.out.println(customerService.getAllCustomerByAddress("日照"));

    }


    @Test
    void testCustomerBuilder() {
        CustomerEntity customerEntity = new CustomerEntity.Builder("周璇", "15315687424", "工商银行", "857412474145277").build();

        assertTrue(customerService.addCustomer(customerEntity));
    }

    @Test
    void testCustomerAddSetMethod() {
        CustomerEntity customerEntity = new CustomerEntity.Builder("陈锋", "159867124421", "建设银行", "9846516516516")
                .setAddress("广州").setRemark("广州是一个很热的地方。").build();

        assertTrue(customerService.addCustomer(customerEntity));
    }
}