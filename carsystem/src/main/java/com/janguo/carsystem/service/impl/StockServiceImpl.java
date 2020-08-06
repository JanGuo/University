package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.StockDao;
import com.janguo.carsystem.dao.StockDetailDao;
import com.janguo.carsystem.domain.StockDetailEntity;
import com.janguo.carsystem.domain.StockEntity;
import com.janguo.carsystem.service.StockService;
import com.janguo.carsystem.vo.StockInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {


    @Resource
    StockDao stockDao;
    @Resource
    StockDetailDao stockDetailDao;

    @Override
    public List<StockEntity> getAllStock() {
        return stockDao.getAllStock();
    }

    @Override
    @Transactional
    public boolean addStock(StockInformation stockInformation, String stockDetailId) {

        StockEntity stockEntity = new StockEntity();
        StockDetailEntity stockDetailEntity = new StockDetailEntity();

        stockDetailEntity.setStockDetailId(stockDetailId);
        stockDetailEntity.setStockId(stockInformation.getStockId());
        stockDetailEntity.setProductId(stockInformation.getProductId());
        stockDetailEntity.setStockMoney(stockInformation.getStockMoney());
        stockDetailEntity.setStockNumber(stockInformation.getStockNumber());


        stockEntity.setStockId(stockInformation.getStockId());
        stockEntity.setStockDetail(stockDetailEntity.getStockDetailId());
        stockEntity.setStockMoney(stockInformation.getStockMoney());
        stockEntity.setDeliveryDate(stockInformation.getDeliveryDate());
        stockEntity.setTransactorId(stockInformation.getTransactorId());
        stockEntity.setStockDate(stockInformation.getStockDate());
        stockEntity.setSupplierId(stockInformation.getSupplierId());


        return stockDao.addStock(stockEntity) && stockDetailDao.addOrderDetail(stockDetailEntity);
    }

    // 编写addStock
    @Override
    @Transactional
    public boolean addStock(StockEntity stockEntity, StockDetailEntity stockDetailEntity) {
        boolean add1 = stockDao.addStock(stockEntity);

        if (!stockDetailEntity.getStockId().equals(stockEntity.getStockId())) {
            stockDetailEntity.setStockId(stockEntity.getStockId());
        }

        if (!stockDetailEntity.getStockDetailId().equals(stockEntity.getStockDetail()))
            return false;


        boolean add2 = stockDetailDao.addOrderDetail(stockDetailEntity);
        return add1 && add2;
    }


    @Override
    public StockEntity getStockById(String id) {
        return stockDao.getStockById(id);
    }

    @Override
    public List<StockEntity> getStockBySupplierId(String supplierId) {
        return stockDao.getStockBySupplierId(supplierId);
    }

    public StockInformation getAllStockInformation(String stockId) {
        StockEntity stock = stockDao.getStockById(stockId);

        String stockDetailId = stock.getStockDetail();
        StockDetailEntity stockDetailEntity = stockDetailDao.getByOrderDetailId(stockDetailId);

        StockInformation stockInformation = new StockInformation();
        stockInformation.setStockId(stockId);
        stockInformation.setDeliveryDate(stock.getDeliveryDate());
        stockInformation.setProductId(stockDetailEntity.getProductId());
        stockInformation.setStockDate(stock.getStockDate());
        stockInformation.setStockNumber(stockDetailEntity.getStockNumber());
        stockInformation.setStockMoney(stockDetailEntity.getStockMoney());
        stockInformation.setTransactorId(stock.getTransactorId());
        stockInformation.setSupplierId(stock.getSupplierId());

        return stockInformation;

    }
}
