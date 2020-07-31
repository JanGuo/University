package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.StockEntity;
import com.janguo.carsystem.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {

    @Autowired
    StockService stockService;
    @Test

    void getAllStock() {
        System.out.println(stockService.getAllStock());
    }

    @Test
    void addStock() {
        StockEntity stock = new StockEntity();
        stock.setStockId("3");
        stock.setSupplierId("3");
        stock.setStockDetail("78");
        stock.setStockDate(new Timestamp(System.currentTimeMillis()));
        stock.setDeliveryDate(new Timestamp(System.currentTimeMillis()));
        stock.setTransactorId("10");
        stock.setStockMoney(10600d);
        stockService.addStock(stock);
    }

    @Test
    void getStockById() {
        System.out.println(stockService.getStockById("2"));
    }

    @Test
    void getStockBySupplierId() {
        System.out.println(stockService.getStockBySupplierId("3"));
    }
}