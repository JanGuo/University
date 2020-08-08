package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.StockDetailEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StockDetailDao {
    /**
     // 采购单细节编号
     private String stockDetailId;
     // 采购单编号
     private String stockId;
     // 产品编号
     private String productId;
     // 采购单数目
     private Integer stockNumber;
     // 采购总金额
     private Double stockMoney;
     */

    @Results(id = "order_stock", value = {
            @Result(property = "stockDetailId", column = "stock_detail_id"),
            @Result(property = "stockId", column = "stock_id"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "stockNumber", column = "stock_number"),
            @Result(property = "stockMoney", column = "stock_money"),
    })
    @Select("select * from stock_detail")
    List<StockDetailEntity> getAll();


    @ResultMap("order_stock")
    @Insert("insert into stock_detail(stock_detail_id,stock_id,product_id,stock_number,stock_money) values(#{stockDetailId},#{stockId},#{productId},#{stockNumber},#{stockMoney})")
    boolean addOrderDetail(StockDetailEntity orderDetail);

    @ResultMap("order_stock")
    @Select("select * from stock_detail where stock_detail_id=#{id}")
    StockDetailEntity getByOrderDetailId(String id);

    @Select("SELECT count(*)  from stock_detail")
    int getIndex();
}