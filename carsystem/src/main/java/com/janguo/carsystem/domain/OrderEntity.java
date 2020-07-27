package com.janguo.carsystem.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "order", schema = "carsystem", catalog = "")
@Data
public class OrderEntity {
    // 订单编号
    private String orderId;
    // 顾客编号
    private String customerId;
    // 订单细节
    private String orderDetail;
    // 订货日期
    private Timestamp orderDate;
    // 预定交货日期
    private Timestamp deliveryDate;
    // 办理人编号
    private String transactorId;
    // 应收金额
    private Double orderMoney;

    @javax.persistence.Id
    @javax.persistence.Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_detail")
    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_date")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "delivery_date")
    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "transactor_id")
    public String getTransactorId() {
        return transactorId;
    }

    public void setTransactorId(String transactorId) {
        this.transactorId = transactorId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_money")
    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(orderDetail, that.orderDetail) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(transactorId, that.transactorId) &&
                Objects.equals(orderMoney, that.orderMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderDetail, orderDate, deliveryDate, transactorId, orderMoney);
    }
}
