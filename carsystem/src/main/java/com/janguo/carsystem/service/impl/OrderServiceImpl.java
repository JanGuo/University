package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.OrderDao;
import com.janguo.carsystem.dao.OrderDetailDao;
import com.janguo.carsystem.domain.OrderDetailEntity;
import com.janguo.carsystem.domain.OrderEntity;
import com.janguo.carsystem.service.OrderService;
import com.janguo.carsystem.vo.OrderInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    OrderDetailDao orderDetailDao;

    @Override
    public List<OrderEntity> getAllOlder() {
        return orderDao.getAllOlder();
    }

    @Override
    @Transactional
    public boolean addOrderAndDetail(OrderEntity orderEntity, OrderDetailEntity orderDetailEntity) {
        boolean add1 = orderDao.addOrder(orderEntity);

        if (!orderDetailEntity.getOrderId().equals(orderEntity.getOrderId())) {
            orderDetailEntity.setOrderId(orderDetailEntity.getOrderId());
        }

        boolean add2 = orderDetailDao.addOrderDetail(orderDetailEntity);
        return add1 && add2;
    }

    @Override
    public OrderInformation getOrderAndDetailById(String id) {
        OrderEntity older = orderDao.getOlderById(id);

        OrderDetailEntity orderDetail = orderDetailDao.getByOrderDetailId(older.getOrderDetail());

        OrderInformation orderInformation = new OrderInformation();
        orderInformation.setOrderId(id);
        orderInformation.setOrderNumber(orderDetail.getOrderNumber());
        orderInformation.setCustomerId(older.getCustomerId());
        orderInformation.setDeliveryDate(older.getDeliveryDate());
        orderInformation.setOrderMoney(older.getOrderMoney());
        orderInformation.setOrderDate(older.getOrderDate());
        orderInformation.setProductId(orderDetail.getProductId());
        orderInformation.setTransactorId(older.getTransactorId());
        return orderInformation;

    }


}
