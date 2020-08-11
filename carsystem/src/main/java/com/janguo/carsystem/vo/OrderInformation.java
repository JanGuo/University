package com.janguo.carsystem.vo;

import com.janguo.carsystem.domain.OrderDetailEntity;
import com.janguo.carsystem.domain.OrderEntity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderInformation {
    // 订单编号
    private String orderId;
    // 顾客编号
    private String customerId;
    // 订货日期
    private Timestamp orderDate;
    // 预定交货日期
    private Timestamp deliveryDate;
    // 办理人编号
    private String transactorId;
    // 应收金额
    private Double orderMoney;
    // 产品编号
    private String productId;
    // 订单数目
    private Integer orderNumber;


    public OrderInformation(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity) {

        if (orderEntity == null || orderDetailEntity == null) {
            throw new NullPointerException("OrderEntity or OrderDetailEntity NPE！");
        }
        this.orderId = orderEntity.getOrderId();
        this.customerId = orderEntity.getCustomerId();
        this.orderDate = orderEntity.getOrderDate();
        this.deliveryDate = orderEntity.getDeliveryDate();
        this.transactorId = orderEntity.getTransactorId();
        this.orderMoney = orderEntity.getOrderMoney();
        if (!orderEntity.getOrderId().equals(orderDetailEntity.getOrderId()))
            throw new IllegalArgumentException("Order Id not equals OrderDetail Id");
        this.productId = orderDetailEntity.getProductId();
        this.orderNumber = orderDetailEntity.getOrderNumber();
    }

    public OrderInformation() {
    }
}
