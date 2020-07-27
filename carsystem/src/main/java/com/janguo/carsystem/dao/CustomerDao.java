package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.CustomerEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerDao {
    @Results(id = "customer",value = {
            @Result(property = "customerId",column = "customer_id"),
            @Result(property = "customerName",column = "customer_name"),
            @Result(property = "customerAddress",column = "customer_address"),
            @Result(property = "customerTel",column = "customer_tel"),
            @Result(property = "customerBank",column = "customer_bank"),
            @Result(property = "customerBankId",column = "customer_bank_id"),
            @Result(property = "customerRemark",column = "customer_remark")
    })
    @Select("select * from customer")
    List<CustomerEntity> getAllCustomer();

    @ResultMap("customer")
    @Select("Select * from customer where customer_id=#{id}")
    CustomerEntity getCustomerById(String id);

    @ResultMap("customer")
    @Select("Select * from customer where customer_address=#{address}")
    List<CustomerEntity> getAllCustomerByAddress(String address);
}
