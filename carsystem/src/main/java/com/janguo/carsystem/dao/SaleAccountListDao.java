package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.SaleAccountListEntity;
import com.janguo.carsystem.domain.StockAccountListEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SaleAccountListDao {
    /**
     // 订单编号
     private String orderId;
     // 应收金额
     private Double orderMoney;
     // 收款日期
     private Timestamp receiveMoneyDate;
     // 已收金额
     private Double receiveMoney;
     // 办理人编号
     private String transactorId;
     */

    @Results(id = "saleAccountList",value = {
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "orderMoney",column = "order_money"),
            @Result(property = "receiveMoneyDate",column = "receive_money_date"),
            @Result(property = "receiveMoney",column = "receive_money"),
            @Result(property = "transactorId",column = "transactor_id"),
    })
    @Select("select * from sale_account_list where order_id=#{id}")
    SaleAccountListEntity getSaleAccountListByOrderId(String id);

    @ResultMap("saleAccountList")
    @Insert("insert into sale_account_list(order_id,order_money,receive_money_date,receive_money,transactor_id) " +
            "values(#{orderId},#{orderMoney},#{receiveMoneyDate},#{receiveMoney},#{transactorId})")
    boolean addSaleAccountList(SaleAccountListEntity saleAccountListEntity);
}