package com.janguo.carsystem.domain;

import lombok.Data;

import java.util.Objects;

/**
 * 订单细节
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "order_detail", schema = "carsystem", catalog = "")
@Data
public class OrderDetailEntity {

    // 订单细节编号
    private String orderDetailId;
    // 订单编号
    private String orderId;
    // 产品编号
    private String productId;
    // 订单数目
    private Integer orderNumber;
    // 订单总价值
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
    @javax.persistence.Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "order_number")
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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
        OrderDetailEntity that = (OrderDetailEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(orderMoney, that.orderMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, orderNumber, orderMoney);
    }
}
