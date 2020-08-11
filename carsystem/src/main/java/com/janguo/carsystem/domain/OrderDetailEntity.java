package com.janguo.carsystem.domain;

import com.janguo.carsystem.vo.index.FindIndex;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 订单细节
 */
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

    public static class Builder {
        private String orderDetailId;

        private String orderId;
        private String productId;

        private Integer orderNumber;

        private Double orderMoney;


        public Builder(String orderId, String productId, Integer orderNumber , Double orderMoney) {
            this.orderDetailId = String.valueOf(FindIndex.orderDetailIndexNow.incrementAndGet());
            this.orderId = orderId;
            this.productId = productId;
            this.orderNumber = orderNumber;
            this.orderMoney = orderMoney;
        }

        public OrderDetailEntity build() {
            return new OrderDetailEntity(this);
        }

    }


    public OrderDetailEntity() {
    }

    private OrderDetailEntity(Builder builder) {
        this.orderDetailId = builder.orderDetailId;
        this.orderId = builder.orderId;
        this.productId = builder.productId;
        this.orderNumber = builder.orderNumber;
        this.orderMoney = builder.orderMoney;
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
