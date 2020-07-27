package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAllCustomer();

    CustomerEntity getCustomerById(String id);

    List<CustomerEntity> getAllCustomerByAddress(String address);
}
