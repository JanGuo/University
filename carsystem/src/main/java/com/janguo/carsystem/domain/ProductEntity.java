package com.janguo.carsystem.domain;

import java.sql.Timestamp;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "product", schema = "carsystem", catalog = "")
public class ProductEntity {
    // 产品编号
    private String productId;
    // 产品名称
    private String productName;
    // 产品数量
    private Integer productNumber;
    // 产品价格
    private Double productPrice;
    // 入库时间
    private Timestamp inStorageTime;

    @javax.persistence.Id
    @javax.persistence.Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "product_number")
    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "product_price")
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "in_storage_time")
    public Timestamp getInStorageTime() {
        return inStorageTime;
    }

    public void setInStorageTime(Timestamp inStorageTime) {
        this.inStorageTime = inStorageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productNumber, that.productNumber) &&
                Objects.equals(productPrice, that.productPrice) &&
                Objects.equals(inStorageTime, that.inStorageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productNumber, productPrice, inStorageTime);
    }
}
