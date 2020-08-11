package com.janguo.carsystem.domain;

import com.janguo.carsystem.vo.index.FindIndex;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

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


    public static class Builder {
        private String orderId;

        private String customerId;
        private String orderDetail;
        private Timestamp orderDate;
        private Timestamp deliveryDate;
        private String transactorId;

        private Double orderMoney;


        public Builder(String customerId, String orderDetail, Timestamp orderDate, Timestamp deliveryDate, String transactorId, Double orderMoney) {
            this.orderId = String.valueOf(FindIndex.orderIndexNow.incrementAndGet());
            this.customerId = customerId;
            this.orderDetail = orderDetail;
            this.orderDate = orderDate;
            this.deliveryDate = deliveryDate;
            this.transactorId = transactorId;
            this.orderMoney = orderMoney;
        }

        public OrderEntity build() {
            return new OrderEntity(this);
        }

    }


    public OrderEntity() {
    }

    private OrderEntity(Builder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.orderDetail = builder.orderDetail;
        this.orderDate = builder.orderDate;
        this.deliveryDate = builder.deliveryDate;
        this.transactorId = builder.transactorId;
        this.orderMoney = builder.orderMoney;
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
