package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.StockEntity;

import java.util.List;

public interface StockService {
    List<StockEntity> getAllStock();
    boolean addStock(StockEntity stock);
    StockEntity getStockById(String id);
    List<StockEntity> getStockBySupplierId(String supplierId);

}
