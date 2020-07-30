package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.SupplierDao;
import com.janguo.carsystem.domain.SupplierEntity;
import com.janguo.carsystem.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Resource
    SupplierDao supplierDao;
    @Override
    public List<SupplierEntity> getAllSupplier() {
        return supplierDao.getAllSupplier();
    }

    @Override
    public boolean addSupplier(SupplierEntity supplier) {
        return supplierDao.addSupplier(supplier);
    }
}
