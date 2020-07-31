package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.StockDao;
import com.janguo.carsystem.domain.StockEntity;
import com.janguo.carsystem.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {


    @Resource
    StockDao stockDao;
    @Override
    public List<StockEntity> getAllStock() {
        return stockDao.getAllStock();
    }

    @Override
    public boolean addStock(StockEntity stock) {
        return stockDao.addStock(stock);
    }

    @Override
    public StockEntity getStockById(String id) {
        return stockDao.getStockById(id);
    }

    @Override
    public List<StockEntity> getStockBySupplierId(String supplierId) {
        return stockDao.getStockBySupplierId(supplierId);
    }
}
