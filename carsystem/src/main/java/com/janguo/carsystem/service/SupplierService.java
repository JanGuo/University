package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.SupplierEntity;

import java.util.List;

public interface SupplierService {
    List<SupplierEntity> getAllSupplier();

    boolean addSupplier(SupplierEntity supplier);

    SupplierEntity getSupplierById(String id);

    SupplierEntity getSupplierByName(String name);

}
