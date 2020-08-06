package com.janguo.carsystem.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StockInformation {
    // 采购单编号
    private String stockId;
    // 产品编号
    private String productId;
    // 采购单数目
    private Integer stockNumber;
    // 采购总金额 // 采购单 交易金额   ------------  double  会不会有问题？？？
    private Double stockMoney;
    // 供应商编号
    private String supplierId;
    // 采购单时间
    private Timestamp stockDate;
    // 采购单 交付时间
    private Timestamp deliveryDate;
    // 办理人编号
    private String transactorId;

}
