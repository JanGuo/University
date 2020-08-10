package com.janguo.carsystem;

import com.janguo.carsystem.vo.index.FindIndex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarSystemApplicationTests {




    @Test
    void testFindIndex() {

        System.out.println("customerIndexNow            --- " + FindIndex.customerIndexNow);
        System.out.println("departmentIndexNow          --- " + FindIndex.departmentIndexNow);
        System.out.println("orderIndexNow               --- " + FindIndex.orderIndexNow);
        System.out.println("orderDetailNow              --- " + FindIndex.orderDetailNow);
        System.out.println("productIndexNow             --- " + FindIndex.productIndexNow);
        System.out.println("saleAccountListIndexNow     --- " + FindIndex.saleAccountListIndexNow);
        System.out.println("staffIndexNow               --- " + FindIndex.staffIndexNow);
        System.out.println("stockAccountListIndexNow    --- " + FindIndex.stockAccountListIndexNow);
        System.out.println("stockIndexNow               --- " + FindIndex.stockIndexNow);
        System.out.println("stockDetailIndexNow         --- " + FindIndex.stockDetailIndexNow);
        System.out.println("storageIndexNow             --- " + FindIndex.storageIndexNow);
        System.out.println("supplierIndexNow            --- " + FindIndex.supplierIndexNow);
    }
}
