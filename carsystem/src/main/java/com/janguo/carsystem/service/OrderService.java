package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOlder();

    boolean addOrder(OrderEntity orderEntity);

}
