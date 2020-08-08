package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.OrderDetailEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @see OrderDetailEntity
 */
@Mapper
public interface OrderDetailDao {
    /**
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
     */

    @Results(id = "order_detail", value = {
            @Result(property = "orderDetailId", column = "order_detail_id"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "orderNumber", column = "order_number"),
            @Result(property = "orderMoney", column = "order_money"),
    })
    @Select("select * from order_detail")
    List<OrderDetailEntity> getAll();


    @ResultMap("order_detail")
    @Insert("insert into order_detail(order_detail_id,order_id,product_id,order_number,order_money) values(#{orderDetailId},#{orderId},#{productId},#{orderNumber},#{orderMoney})")
    boolean addOrderDetail(OrderDetailEntity orderDetail);

    @ResultMap("order_detail")
    @Select("select * from order_detail where order_detail_id=#{id}")
    OrderDetailEntity getByOrderDetailId(String id);


    @Select("SELECT count(*)  from order_detail")
    int getIndex();
}
