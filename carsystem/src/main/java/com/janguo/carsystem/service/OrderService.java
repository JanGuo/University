package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.OrderDetailEntity;
import com.janguo.carsystem.domain.OrderEntity;
import com.janguo.carsystem.vo.OrderInformation;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOlder();

    boolean addOrderAndDetail(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity);

    OrderInformation getOrderAndDetailById(String id);
}
