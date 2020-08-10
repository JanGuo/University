package com.janguo.carsystem.vo.index;

import com.janguo.carsystem.dao.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FindIndex {

    @Resource
    CustomerDao customerDao;

    public static AtomicInteger customerIndexNow = new AtomicInteger(0);

    @Resource
    DepartmentDao departmentDao;

    public static AtomicInteger departmentIndexNow = new AtomicInteger(0);

    @Resource
    OrderDao orderDao;

    public static AtomicInteger orderIndexNow = new AtomicInteger(0);

    @Resource
    OrderDetailDao orderDetailDao;

    public static AtomicInteger orderDetailNow = new AtomicInteger(0);

    @Resource
    ProductDao productDao;

    public static AtomicInteger productIndexNow = new AtomicInteger(0);

    @Resource
    SaleAccountListDao saleAccountListDao;

    public static AtomicInteger saleAccountListIndexNow = new AtomicInteger(0);

    @Resource
    StaffDao staffDao;

    public static AtomicInteger staffIndexNow = new AtomicInteger(0);

    @Resource
    StockAccountListDao stockAccountListDao;

    public static AtomicInteger stockAccountListIndexNow = new AtomicInteger(0);

    @Resource
    StockDao stockDao;

    public static AtomicInteger stockIndexNow = new AtomicInteger(0);
    @Resource
    StockDetailDao stockDetailDao;

    public static AtomicInteger stockDetailIndexNow = new AtomicInteger(0);

    @Resource
    StorageDao storageDao;

    public static AtomicInteger storageIndexNow = new AtomicInteger(0);

    @Resource
    SupplierDao supplierDao;

    public static AtomicInteger supplierIndexNow = new AtomicInteger(0);

    public void getIndex() {

        customerIndexNow.set(customerDao.getIndex());
        departmentIndexNow.set(departmentDao.getIndex());
        orderIndexNow.set(orderDao.getIndex());
        orderDetailNow.set(orderDetailDao.getIndex());
        productIndexNow.set(productDao.getIndex());
        saleAccountListIndexNow.set(saleAccountListDao.getIndex());
        staffIndexNow.set(staffDao.getIndex());
        stockAccountListIndexNow.set(stockAccountListDao.getIndex());
        stockIndexNow.set(stockDao.getIndex());
        stockDetailIndexNow.set(stockDetailDao.getIndex());
        storageIndexNow.set(storageDao.getIndex());
        supplierIndexNow.set(supplierDao.getIndex());

    }


}
