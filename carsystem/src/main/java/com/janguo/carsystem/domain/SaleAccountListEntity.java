package com.janguo.carsystem.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 应收款明细
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "sale_account_list", schema = "carsystem", catalog = "")
@Data
public class SaleAccountListEntity {
    // 订单编号
    private String orderId;
    // 应收金额
    private Double orderMoney;
    // 收款日期
    private Timestamp receiveMoneyDate;
    // 已收金额
    private Double receiveMoney;
    // 办理人编号
    private String transactorId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_money")
    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    @javax.persistence.Id
    @javax.persistence.Column(name = "receive_money_date")
    public Timestamp getReceiveMoneyDate() {
        return receiveMoneyDate;
    }

    public void setReceiveMoneyDate(Timestamp receiveMoneyDate) {
        this.receiveMoneyDate = receiveMoneyDate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "receive_money")
    public Double getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(Double receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "transactor_id")
    public String getTransactorId() {
        return transactorId;
    }

    public void setTransactorId(String transactorId) {
        this.transactorId = transactorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleAccountListEntity that = (SaleAccountListEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(orderMoney, that.orderMoney) &&
                Objects.equals(receiveMoneyDate, that.receiveMoneyDate) &&
                Objects.equals(receiveMoney, that.receiveMoney) &&
                Objects.equals(transactorId, that.transactorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderMoney, receiveMoneyDate, receiveMoney, transactorId);
    }
}
