package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.ProductEntity;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @see ProductEntity
 */
@Mapper
public interface ProductDao {
    @Results(id = "product", value = {
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productNumber", column = "product_number"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "inStorageTime", column = "in_storage_time")
    })
    @Select("select * from product")
    List<ProductEntity> getAllProduct();

    @ResultMap("product")
    @Insert("insert into product(product_id,product_name,product_number,product_price,in_storage_time) values(#{productId},#{productName},#{productNumber},#{productPrice},#{inStorageTime})")
    boolean addProduct(ProductEntity product);

    @ResultMap("product")
    @Select("select * from product where product_id=#{id}")
    ProductEntity getProductById(String id);

    @ResultMap("product")
    @Select("select * from product where product_price=#{name}")
    ProductEntity getProductByName(String name);

    @ResultMap("product")
    @Select("select * from product where product_price>=#{price}")
    List<ProductEntity> getAllPriceUpValue(Integer price);

    @ResultMap("product")
    @Select("select * from product where in_storage_time<=#{timestamp}")
    List<ProductEntity> getAllProductTimeDownValue(Timestamp timestamp);

}
