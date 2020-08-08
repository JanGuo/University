package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.StorageEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StorageDao {
    /**
     *     // 仓库编号
     *     private String storageId;
     *     // 仓库地址
     *     private String storageAddress;
     *     // 产品编号
     *     private String productId;
     *     // 产品数目
     *     private Integer productNumber;
     */
    @Results(id = "storage",value = {
            @Result(property = "storageId",column = "storage_id"),
            @Result(property = "storageAddress",column = "storage_address"),
            @Result(property = "productId",column = "product_id"),
            @Result(property = "productNumber",column = "product_number"),
    })
    @Select("select * from storage")
    List<StorageEntity> getAllStorage();

    @ResultMap("storage")
    @Insert("insert into storage(storage_id,storage_address,product_id,product_number) values(#{storageId},#{storageAddress},#{productId},#{productNumber})")
    boolean addStorage(StorageEntity storage);

    @ResultMap("storage")
    @Select("select * from storage where storage_id=#{id}")
    StorageEntity getStorageById(String id);

    @Select("SELECT count(*)  from storage")
    int getIndex();
}
