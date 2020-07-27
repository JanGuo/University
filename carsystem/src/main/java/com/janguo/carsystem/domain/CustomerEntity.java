package com.janguo.carsystem.domain;

import lombok.Data;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "customer", schema = "carsystem", catalog = "")
@Data
public class CustomerEntity {
    // 顾客编号
    private String customerId;
    // 顾客姓名
    private String customerName;
    // 顾客地址
    private String customerAddress;
    // 顾客电话
    private String customerTel;
    // 顾客开户行
    private String customerBank;
    // 顾客开户行账号
    private String customerBankId;
    // 顾客备注
    private String customerRemark;

    @javax.persistence.Id
    @javax.persistence.Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_address")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_tel")
    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_bank")
    public String getCustomerBank() {
        return customerBank;
    }

    public void setCustomerBank(String customerBank) {
        this.customerBank = customerBank;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_bank_id")
    public String getCustomerBankId() {
        return customerBankId;
    }

    public void setCustomerBankId(String customerBankId) {
        this.customerBankId = customerBankId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_remark")
    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerAddress, that.customerAddress) &&
                Objects.equals(customerTel, that.customerTel) &&
                Objects.equals(customerBank, that.customerBank) &&
                Objects.equals(customerBankId, that.customerBankId) &&
                Objects.equals(customerRemark, that.customerRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerAddress, customerTel, customerBank, customerBankId, customerRemark);
    }

}
