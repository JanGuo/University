package com.janguo.carsystem.domain;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 应付款明细
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "stock_account_list", schema = "carsystem", catalog = "")
public class StockAccountListEntity {
    // 采购单编号
    private String stockId;
    // 应付金额
    private Double stockMoney;
    // 支付日期
    private Timestamp stockMoneyDate;
    // 已付金额
    private Double havepayMoney;
    //办理人编号
    private String transactorId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_id")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_money")
    public Double getStockMoney() {
        return stockMoney;
    }

    public void setStockMoney(Double stockMoney) {
        this.stockMoney = stockMoney;
    }

    @javax.persistence.Id
    @javax.persistence.Column(name = "stock_money_date")
    public Timestamp getStockMoneyDate() {
        return stockMoneyDate;
    }

    public void setStockMoneyDate(Timestamp stockMoneyDate) {
        this.stockMoneyDate = stockMoneyDate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "havepay_money")
    public Double getHavepayMoney() {
        return havepayMoney;
    }

    public void setHavepayMoney(Double havepayMoney) {
        this.havepayMoney = havepayMoney;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "transactor_id")
    public String getTransactorId() {
        return transactorId;
    }

    public void setTransactorId(String transactorId) {
        this.transactorId = transactorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockAccountListEntity that = (StockAccountListEntity) o;
        return Objects.equals(stockId, that.stockId) &&
                Objects.equals(stockMoney, that.stockMoney) &&
                Objects.equals(stockMoneyDate, that.stockMoneyDate) &&
                Objects.equals(havepayMoney, that.havepayMoney) &&
                Objects.equals(transactorId, that.transactorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, stockMoney, stockMoneyDate, havepayMoney, transactorId);
    }
}
