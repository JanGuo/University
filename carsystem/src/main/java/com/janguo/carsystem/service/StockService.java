package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.StockDetailEntity;
import com.janguo.carsystem.domain.StockEntity;
import com.janguo.carsystem.vo.StockInformation;

import java.util.List;

public interface StockService {
    List<StockEntity> getAllStock();

    boolean addStock(StockInformation stockInformation, String stockDetailId);

    boolean addStock(StockEntity stockEntity, StockDetailEntity stockDetailEntity) throws Exception;

    StockEntity getStockById(String id);

    List<StockEntity> getStockBySupplierId(String supplierId);

    StockInformation getAllStockInformation(String stockId);

}
