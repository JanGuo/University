package com.janguo.carsystem.domain;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "storage", schema = "carsystem", catalog = "")
public class StorageEntity {
    // 仓库编号
    private String storageId;
    // 仓库地址
    private String storageAddress;
    // 产品编号
    private String productId;
    // 产品数目
    private Integer productNumber;

    @javax.persistence.Id
    @javax.persistence.Column(name = "storage_id")
    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "storage_address")
    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "product_number")
    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageEntity that = (StorageEntity) o;
        return Objects.equals(storageId, that.storageId) &&
                Objects.equals(storageAddress, that.storageAddress) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productNumber, that.productNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageId, storageAddress, productId, productNumber);
    }
}
