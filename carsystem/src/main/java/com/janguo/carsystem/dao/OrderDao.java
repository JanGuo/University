package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.OrderEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    @Results(id = "order", value =
            {
                    @Result(property = "orderId",column = "order_id"),
                    @Result(property = "customerId",column = "customer_id"),
                    @Result(property = "orderDetail",column = "order_detail"),
                    @Result(property = "orderDate",column = "order_date"),
                    @Result(property = "deliveryDate",column = "delivery_date"),
                    @Result(property = "transactorId",column = "transactor_id"),
                    @Result(property = "orderMoney",column = "order_money"),
            })
    @Select("select * from order1")
    List<OrderEntity> getAllOlder();

    @ResultMap("order")
    @Insert("insert into order1(order_id,customer_id,order_detail,order_date,delivery_date,transactor_id,order_money) values(#{orderId},#{customerId},#{orderDetail},#{orderDate},#{deliveryDate},#{transactorId},#{orderMoney})")
    boolean addOrder(OrderEntity orderEntity);
}
