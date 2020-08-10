package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.ProductEntity;
import com.janguo.carsystem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    void testGetAllProduct() {
        System.out.println(productService.getAllProduct());
    }

    @Test
    void testAddProduct() {
        ProductEntity product = new ProductEntity();
        product.setProductId("3");
        product.setProductName("连杆");
        product.setProductNumber(29);
        product.setProductPrice(500d);
        product.setInStorageTime(new Timestamp(System.currentTimeMillis()));
        assertTrue(productService.addProduct(product));
    }

    @Test
    void testGetProductByID() {
        System.out.println(productService.getProductById("1"));
    }

    @Test
    void testGetProductByName() {
        System.out.println(productService.getProductByName("活塞"));
    }

    @Test
    void testGetProductUpValuePrice() {
        System.out.println(productService.getAllPriceUpValue(500));
    }

    @Test
    void testGetProductDownValueInStorage() {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minus(13, ChronoUnit.MINUTES);
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime1.atZone(zoneId).toInstant();

        Date date = Date.from(instant);
        System.out.println(productService.getAllProductTimeDownValue(new Timestamp(date.getTime())));
    }

    @Test
    void testProductBuilder() {
        ProductEntity product = new ProductEntity.Builder("Z轴承", 10, 200D, new Timestamp(System.currentTimeMillis())).build();

        assertTrue(productService.addProduct(product));
    }
}