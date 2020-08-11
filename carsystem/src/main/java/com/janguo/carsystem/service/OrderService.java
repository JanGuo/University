package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.OrderDetailEntity;
import com.janguo.carsystem.domain.OrderEntity;
import com.janguo.carsystem.vo.OrderInformation;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOlder();

    boolean addOrderAndDetail(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity);

    /**
     * add Order and OrderDetail
     * @param orderInformation 由Order和OrderDetail封装的对象
     * @param orderDetailId orderDetailId 的 ID值
     * @return
     */
    boolean addOrderAndDetail(OrderInformation orderInformation, String orderDetailId);

    OrderInformation getOrderAndDetailById(String id);
}
