package com.janguo.carsystem;

import com.janguo.carsystem.vo.index.FindIndex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarsystemApplicationTests {


    @Autowired
    FindIndex findIndex;

    @Test
    void testFindIndex() {

        System.out.println("customerIndexNow            --- " + findIndex.customerIndexNow);
        System.out.println("departmentIndexNow          --- " + findIndex.departmentIndexNow);
        System.out.println("orderIndexNow               --- " + findIndex.orderIndexNow);
        System.out.println("orderDetailNow              --- " + findIndex.orderDetailNow);
        System.out.println("productIndexNow             --- " + findIndex.productIndexNow);
        System.out.println("saleAccountListIndexNow     --- " + findIndex.saleAccountListIndexNow);
        System.out.println("staffIndexNow               --- " + findIndex.staffIndexNow);
        System.out.println("stockAccountListIndexNow    --- " + findIndex.stockAccountListIndexNow);
        System.out.println("stockIndexNow               --- " + findIndex.stockIndexNow);
        System.out.println("stockDetailIndexNow         --- " + findIndex.stockDetailIndexNow);
        System.out.println("storageIndexNow             --- " + findIndex.storageIndexNow);
        System.out.println("supplierIndexNow            --- " + findIndex.supplierIndexNow);
    }
}
