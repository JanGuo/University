package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.ProductDao;
import com.janguo.carsystem.domain.ProductEntity;
import com.janguo.carsystem.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductDao productDao;

    @Override
    public List<ProductEntity> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public boolean addProduct(ProductEntity product) {
        return productDao.addProduct(product);
    }

    @Override
    public ProductEntity getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Override
    public ProductEntity getProductByName(String name) {
        return productDao.getProductByName(name);
    }

    @Override
    public List<ProductEntity> getAllPriceUpValue(Integer price) {
        return productDao.getAllPriceUpValue(price);
    }

    @Override
    public List<ProductEntity> getAllProductTimeDownValue(Timestamp timestamp) {
        return productDao.getAllProductTimeDownValue(timestamp);
    }


}
