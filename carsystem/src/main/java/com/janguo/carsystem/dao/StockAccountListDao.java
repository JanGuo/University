package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.StockAccountListEntity;
import com.janguo.carsystem.domain.StockEntity;
import org.apache.ibatis.annotations.*;


@Mapper
public interface StockAccountListDao {
    /**
     * // 采购单编号
     *     private String stockId;
     *     // 应付金额
     *     private Double stockMoney;
     *     // 支付日期
     *     private Timestamp stockMoneyDate;
     *     // 已付金额
     *     private Double havepayMoney;
     *     //办理人编号
     *     private String transactorId;
     */

    @Results(id = "stockAccountList",value = {
            @Result(property = "stockId",column = "stock_id"),
            @Result(property = "stockMoney",column = "stock_money"),
            @Result(property = "stockMoneyDate",column = "stock_money_date"),
            @Result(property = "havePayMoney",column = "have_pay_money"),
            @Result(property = "transactorId",column = "transactor_id"),
    })
    @Select("select * from stock_account_list where stock_id=#{id}")
    StockAccountListEntity getStockAccountListByStockId(String id);


    @ResultMap("stockAccountList")
    @Insert("insert into stock_account_list(stock_id,stock_money,stock_money_date,have_pay_money,transactor_id) " +
            "values(#{stockId},#{stockMoney},#{stockMoneyDate},#{havePayMoney},#{transactorId})")
    boolean addStockAccountList(StockAccountListEntity stockAccountListEntity);
}
