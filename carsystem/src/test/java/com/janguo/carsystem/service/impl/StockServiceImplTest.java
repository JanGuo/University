package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.SaleAccountListDao;
import com.janguo.carsystem.dao.StockAccountListDao;
import com.janguo.carsystem.dao.StockDetailDao;
import com.janguo.carsystem.domain.OrderDetailEntity;
import com.janguo.carsystem.domain.StockAccountListEntity;
import com.janguo.carsystem.domain.StockDetailEntity;
import com.janguo.carsystem.domain.StockEntity;
import com.janguo.carsystem.service.StockService;
import com.janguo.carsystem.vo.StockInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;
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

        StockInformation stockInformation = new StockInformation();
        stockInformation.setStockId("5");
        stockInformation.setDeliveryDate(new Timestamp(System.currentTimeMillis()));
        stockInformation.setProductId("json");
        stockInformation.setStockDate(new Timestamp(System.currentTimeMillis()));
        stockInformation.setStockNumber(100);
        stockInformation.setStockMoney(25000d);
        stockInformation.setTransactorId("1");
        stockInformation.setSupplierId("3");

        stockService.addStock(stockInformation, "2");
    }
    @Test
    void testAddStock() {
        StockEntity stockEntity = new StockEntity();
        StockDetailEntity stockDetailEntity = new StockDetailEntity();

        stockEntity.setStockId("8");
        stockEntity.setSupplierId("1");
        stockEntity.setStockDate(new Timestamp(System.currentTimeMillis()));
        stockEntity.setDeliveryDate(new Timestamp(System.currentTimeMillis()));
        stockEntity.setStockDetail("4");
        stockEntity.setStockMoney(2358d);
        stockEntity.setTransactorId("10");

        stockDetailEntity.setStockDetailId("4");
        stockDetailEntity.setStockId(stockEntity.getStockId());
        stockDetailEntity.setProductId("json");
        stockDetailEntity.setStockNumber(254);
        stockDetailEntity.setStockMoney(stockEntity.getStockMoney());

        try {
            assertTrue(stockService.addStock(stockEntity,stockDetailEntity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getStockById() {
        System.out.println(stockService.getStockById("2"));
    }

    @Test
    void getStockBySupplierId() {
        System.out.println(stockService.getStockBySupplierId("3"));
    }


    @Test
    void getAllStockInformation() {
        System.out.println(stockService.getAllStockInformation("1"));
    }

    @Resource
    StockAccountListDao stockAccountListDao;

    @Test
    void addStockAccountList() {

        StockAccountListEntity stockAccountList = new StockAccountListEntity();
        stockAccountList.setStockId("1");
        stockAccountList.setStockMoney(1000d);
        stockAccountList.setStockMoneyDate(new Timestamp(System.currentTimeMillis()));
        stockAccountList.setHavePayMoney(200d);
        stockAccountList.setTransactorId("1");

        assertTrue(stockAccountListDao.addStockAccountList(stockAccountList));
    }
    @Test
    void getStockAccountList() {
        System.out.println(stockAccountListDao.getStockAccountListByStockId("1"));
    }
}