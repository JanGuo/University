package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.OrderDetailEntity;
import com.janguo.carsystem.domain.OrderEntity;
import com.janguo.carsystem.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    void testGetAllOrder() {
        System.out.println(orderService.getAllOlder());

    }

    @Test
    void testAddOrder() {
        OrderEntity orderEntity = new OrderEntity();

        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        LocalDateTime expiredDateTime = nowLocalDateTime.plus(1, ChronoUnit.DAYS);

        ZoneId zone = ZoneId.systemDefault();

        Instant nowInstant = nowLocalDateTime.atZone(zone).toInstant();
        Instant expiredInstant = expiredDateTime.atZone(zone).toInstant();

        Date nowDate = Date.from(nowInstant);
        Date expiredDate111 = Date.from(expiredInstant);

        long dateTime = nowDate.getTime();
        Timestamp nowTimestamp = new Timestamp(dateTime);

        long expiredDateLong = expiredDate111.getTime();
        Timestamp expiredTimestamp = new Timestamp(expiredDateLong);

        orderEntity.setOrderId("4");
        orderEntity.setCustomerId("1");
        orderEntity.setOrderDate(nowTimestamp);
        orderEntity.setDeliveryDate(expiredTimestamp);
        orderEntity.setOrderDetail("1");
        orderEntity.setOrderMoney(1000d);
        orderEntity.setTransactorId("10");

        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setOrderDetailId("1");
        orderDetailEntity.setOrderId(orderEntity.getOrderId());
        orderDetailEntity.setProductId("json");
        orderDetailEntity.setOrderNumber(100);
        orderDetailEntity.setOrderMoney(orderEntity.getOrderMoney());

        assertTrue(orderService.addOrderAndDetail(orderEntity, orderDetailEntity));
    }

    @Test
    void addOrderAndDetailById() {
        System.out.println(orderService.getOrderAndDetailById("4"));
    }
}