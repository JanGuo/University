package com.janguo.carsystem.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "stock", schema = "carsystem", catalog = "")
@Data
public class StockEntity {
    // 采购单编号
    private String stockId;
    // 供应商编号
    private String supplierId;
    // 采购单细节编号
    private String stockDetail;
    // 采购单时间
    private Timestamp stockDate;
    // 采购单 交付时间
    private Timestamp deliveryDate;
    // 办理人编号
    private String transactorId;
    // 采购单 交易金额   ------------  double  会不会有问题？？？
    private Double stockMoney;

    @javax.persistence.Id
    @javax.persistence.Column(name = "stock_ID")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_ID")
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String victualerId) {
        this.supplierId = victualerId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_detail")
    public String getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(String stockDetail) {
        this.stockDetail = stockDetail;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock_date")
    public Timestamp getStockDate() {
        return stockDate;
    }

    public void setStockDate(Timestamp stockDate) {
        this.stockDate = stockDate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "delivery_date")
    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "transactor_ID")
    public String getTransactorId() {
        return transactorId;
    }

    public void setTransactorId(String transactorId) {
        this.transactorId = transactorId;
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
        StockEntity that = (StockEntity) o;
        return Objects.equals(stockId, that.stockId) &&
                Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(stockDetail, that.stockDetail) &&
                Objects.equals(stockDate, that.stockDate) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(transactorId, that.transactorId) &&
                Objects.equals(stockMoney, that.stockMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, supplierId, stockDetail, stockDate, deliveryDate, transactorId, stockMoney);
    }
}
