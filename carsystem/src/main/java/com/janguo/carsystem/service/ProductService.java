package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.ProductEntity;

import java.sql.Timestamp;
import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduct();
    boolean addProduct(ProductEntity product);
    ProductEntity getProductById(String id);
    ProductEntity getProductByName(String name);
    List<ProductEntity> getAllPriceUpValue(Integer price);
    List<ProductEntity> getAllProductTimeDownValue(Timestamp timestamp);

}
