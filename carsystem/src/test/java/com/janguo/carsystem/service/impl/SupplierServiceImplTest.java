package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.SupplierEntity;
import com.janguo.carsystem.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupplierServiceImplTest {

    @Autowired
    SupplierService supplierService;

    @Test
    void getAllSupplier() {
        System.out.println(supplierService.getAllSupplier());
    }

    @Test
    void addSupplier() {

        SupplierEntity supplier = new SupplierEntity();
        supplier.setSupplierId("1");
        supplier.setSupplierName("阳光汽车零件批发");
        supplier.setSupplierAddress("日照三庄");
        supplier.setSupplierTel("225896");
        supplier.setSupplierBank("农业");
        supplier.setSupplierBankId("72015896752148");
        supplier.setSupplierRemark("很好的零件厂，欢迎前来采购");

        assertTrue(supplierService.addSupplier(supplier));
    }
}