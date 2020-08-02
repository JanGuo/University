package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.StorageEntity;
import com.janguo.carsystem.service.StockService;
import com.janguo.carsystem.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StorageServiceImplTest {

    @Autowired
    StorageService storageService;
    @Test
    void getAllStorage() {
        System.out.println(storageService.getAllStorage());
    }

    @Test
    void addStorage() {
        StorageEntity storageEntity = new StorageEntity();
        storageEntity.setStorageId("1");
        storageEntity.setStorageAddress("广东");

        storageEntity.setProductId("2");
        storageEntity.setProductNumber(3);
        assertTrue(storageService.addStorage(storageEntity));
    }

    @Test
    void getStorageById() {
        System.out.println(storageService.getStorageById("1"));
    }
}