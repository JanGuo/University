package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.StockEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StockDao {
    /**
     *     // 采购单编号
     *     private String stockId;
     *     // 供应商编号
     *     private String supplierId;
     *     // 采购单细节编号
     *     private String stockDetail;
     *     // 采购单时间
     *     private Timestamp stockDate;
     *     // 采购单 交付时间
     *     private Timestamp deliveryDate;
     *     // 办理人编号
     *     private String transactorId;
     *     // 采购单 交易金额
     *     private Double stockMoney;
     * @return
     */
    @Results(id = "stock",value = {
            @Result(property = "stockId",column = "stock_id"),
            @Result(property = "supplierId",column = "supplier_id"),
            @Result(property = "stockDetail",column = "stock_detail"),
            @Result(property = "stockDate",column = "stock_date"),
            @Result(property = "deliveryDate",column = "delivery_date"),
            @Result(property = "transactorId",column = "transactor_id"),
            @Result(property = "stockMoney",column = "stock_money"),
    })
    @Select("select * from stock")
    List<StockEntity> getAllStock();

    @ResultMap("stock")
    @Insert("insert into stock(stock_id,supplier_id,stock_detail,stock_date,delivery_date,transactor_id,stock_money) " +
            "values(#{stockId},#{supplierId},#{stockDetail},#{stockDate},#{deliveryDate},#{transactorId},#{stockMoney})")
    boolean addStock(StockEntity stock);

    @ResultMap("stock")
    @Select("select * from stock where stock_id=#{id}")
    StockEntity getStockById(String id);

    @ResultMap("stock")
    @Select("select * from stock where supplier_id=#{supplierId}")
    List<StockEntity> getStockBySupplierId(String supplierId);
}
