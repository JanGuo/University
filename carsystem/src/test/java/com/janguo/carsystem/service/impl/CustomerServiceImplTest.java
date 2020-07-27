package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.service.CustomerService;
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
}