package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.SupplierEntity;
import com.janguo.carsystem.service.SupplierService;
import com.janguo.carsystem.vo.index.FindIndex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupplierServiceImplTest {

    @Autowired
    SupplierService supplierService;

    @Autowired
    FindIndex findIndex;

    @Test
    void getAllSupplier() {
        System.out.println(supplierService.getAllSupplier());
    }

    @Test
    void addSupplier() {

        SupplierEntity supplier = new SupplierEntity();
        int i = findIndex.supplierIndexNow.incrementAndGet();
        supplier.setSupplierId(Integer.toString(i));
        supplier.setSupplierName("北京汽车零件批发");
        supplier.setSupplierAddress("北京");
        supplier.setSupplierTel("85711");
        supplier.setSupplierBank("中国银行");
        supplier.setSupplierBankId("64561616561");
        supplier.setSupplierRemark("中国最大的零件厂，欢迎前来采购");


        assertTrue(supplierService.addSupplier(supplier));
    }

    @Test
    void getSupplierById() {
        System.out.println(supplierService.getSupplierById("1"));
    }

    @Test
    void getSupplierByName() {
        System.out.println(supplierService.getSupplierByName("阳光汽车零件批发"));

    }
}