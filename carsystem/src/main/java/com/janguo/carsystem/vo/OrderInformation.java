package com.janguo.carsystem.vo;

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
}
