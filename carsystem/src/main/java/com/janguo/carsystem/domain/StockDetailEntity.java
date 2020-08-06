package com.janguo.carsystem.domain;

import lombok.Data;

import java.util.Objects;

/**
 * 采购单细节
 */
//@javax.persistence.Entity
@javax.persistence.Table(name = "stock_detail", schema = "carsystem", catalog = "")
@Data
public class StockDetailEntity {
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

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_ID")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "product_ID")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_number")
    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_money")
    public Double getStockMoney() {
        return stockMoney;
    }

    public void setStockMoney(Double stockMoney) {
        this.stockMoney = stockMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDetailEntity that = (StockDetailEntity) o;
        return Objects.equals(stockId, that.stockId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(stockNumber, that.stockNumber) &&
                Objects.equals(stockMoney, that.stockMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, productId, stockNumber, stockMoney);
    }
}
