package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.OrderDao;
import com.janguo.carsystem.domain.OrderEntity;
import com.janguo.carsystem.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;
    @Override
    public List<OrderEntity> getAllOlder() {
        return orderDao.getAllOlder();
    }

    @Override
    public boolean addOrder(OrderEntity orderEntity) {
        return orderDao.addOrder(orderEntity);
    }
}
