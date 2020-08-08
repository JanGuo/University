package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.SupplierEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SupplierDao {

    @Results(id = "supplier",value = {
            @Result(property = "supplierId",column = "supplier_id"), // 供应商编号
            @Result(property = "supplierName",column = "supplier_name"),// 供应商名称
            @Result(property = "supplierAddress",column = "supplier_address"),// 供应商地址
            @Result(property = "supplierTel",column = "supplier_tel"),// 供应商电话
            @Result(property = "supplierBank",column = "supplier_bank"),// 供应商开户行编号
            @Result(property = "supplierBankId",column = "supplier_bank_id"),// 供应商账号
            @Result(property = "supplierRemark",column = "supplier_remark")// 供应商备注
    })
    @Select("select * from supplier")
    List<SupplierEntity> getAllSupplier();

    @ResultMap("supplier")
    @Insert("insert into supplier(supplier_id,supplier_name,supplier_address,supplier_tel,supplier_bank,supplier_bank_id,supplier_remark)" +
            "values(#{supplierId},#{supplierName},#{supplierAddress},#{supplierTel},#{supplierBank},#{supplierBankId},#{supplierRemark})")
    boolean addSupplier(SupplierEntity supplier);

    @ResultMap("supplier")
    @Select("select * from supplier where supplier_id=#{id}")
    SupplierEntity getSupplierById(String id);

    @ResultMap("supplier")
    @Select("select * from supplier where supplier_name=#{name}")
    SupplierEntity getSupplierByName(String name);

    @Select("SELECT count(*)  from supplier")
    int getIndex();
}
