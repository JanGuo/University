package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.CustomerDao;
import com.janguo.carsystem.domain.CustomerEntity;
import com.janguo.carsystem.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Resource
    CustomerDao customerDao;
    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public CustomerEntity getCustomerById(String id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public List<CustomerEntity> getAllCustomerByAddress(String address) {
        return customerDao.getAllCustomerByAddress(address);
    }
}
