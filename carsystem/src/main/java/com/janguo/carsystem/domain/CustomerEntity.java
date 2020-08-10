package com.janguo.carsystem.domain;

import com.janguo.carsystem.vo.index.FindIndex;
import lombok.Data;

import java.util.Objects;

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


    public static class Builder {
        private String customerId;

        private String customerName;
        private String customerAddress = "";
        private String customerTel;
        private String customerBank;
        private String customerBankId;

        private String customerRemark = "";


        public Builder(String customerName, String customerTel, String customerBank, String customerBankId) {
            this.customerId = String.valueOf(FindIndex.customerIndexNow.incrementAndGet());
            this.customerName = customerName;
            this.customerTel = customerTel;
            this.customerBank = customerBank;
            this.customerBankId = customerBankId;
        }

        public Builder setAddress(String address) {
            this.customerAddress = address;
            return this;
        }

        public Builder setRemark(String remark) {
            this.customerRemark = remark;
            return this;
        }

        public CustomerEntity build(){
            return new CustomerEntity(this);
        }

    }


    private CustomerEntity(Builder customerBuilder) {
        this.customerId = customerBuilder.customerId;
        this.customerName = customerBuilder.customerName;
        this.customerAddress = customerBuilder.customerAddress;
        this.customerTel = customerBuilder.customerTel;
        this.customerBank = customerBuilder.customerBank;
        this.customerBankId = customerBuilder.customerBankId;
        this.customerRemark = customerBuilder.customerRemark;
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
