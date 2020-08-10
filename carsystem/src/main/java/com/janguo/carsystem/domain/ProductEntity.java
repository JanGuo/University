package com.janguo.carsystem.domain;

import com.janguo.carsystem.vo.index.FindIndex;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;


@Data
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

    public static class Builder {
        private String productId;

        private String productName;
        private Integer productNumber;
        private Double productPrice;
        private Timestamp inStorageTime;



        public Builder(String productName, Integer productNumber, Double productPrice, Timestamp inStorageTime) {
            this.productId = String.valueOf(FindIndex.productIndexNow.incrementAndGet());
            this.productName = productName;
            this.productNumber = productNumber;
            this.productPrice = productPrice;
            this.inStorageTime = inStorageTime;
        }



        public ProductEntity build(){
            return new ProductEntity(this);
        }

    }


    private ProductEntity(ProductEntity.Builder customerBuilder) {
        this.productId = customerBuilder.productId;
        this.productName = customerBuilder.productName;
        this.productNumber = customerBuilder.productNumber;
        this.productPrice = customerBuilder.productPrice;
        this.inStorageTime = customerBuilder.inStorageTime;
    }

    public ProductEntity() {
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
