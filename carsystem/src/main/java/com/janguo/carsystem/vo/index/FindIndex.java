package com.janguo.carsystem.vo.index;

import com.janguo.carsystem.dao.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FindIndex {

    @Resource
    CustomerDao customerDao;

    public AtomicInteger customerIndexNow = new AtomicInteger(0);

    @Resource
    DepartmentDao departmentDao;

    public AtomicInteger departmentIndexNow = new AtomicInteger(0);

    @Resource
    OrderDao orderDao;

    public AtomicInteger orderIndexNow = new AtomicInteger(0);

    @Resource
    OrderDetailDao orderDetailDao;

    public AtomicInteger orderDetailNow = new AtomicInteger(0);

    @Resource
    ProductDao productDao;

    public AtomicInteger productIndexNow = new AtomicInteger(0);

    @Resource
    SaleAccountListDao saleAccountListDao;

    public AtomicInteger saleAccountListIndexNow = new AtomicInteger(0);

    @Resource
    StaffDao staffDao;

    public AtomicInteger staffIndexNow = new AtomicInteger(0);

    @Resource
    StockAccountListDao stockAccountListDao;

    public AtomicInteger stockAccountListIndexNow = new AtomicInteger(0);

    @Resource
    StockDao stockDao;

    public AtomicInteger stockIndexNow = new AtomicInteger(0);
    @Resource
    StockDetailDao stockDetailDao;

    public AtomicInteger stockDetailIndexNow = new AtomicInteger(0);

    @Resource
    StorageDao storageDao;

    public AtomicInteger storageIndexNow = new AtomicInteger(0);

    @Resource
    SupplierDao supplierDao;

    public AtomicInteger supplierIndexNow = new AtomicInteger(0);

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
