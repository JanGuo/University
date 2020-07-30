package com.janguo.carsystem.domain;

import lombok.Data;

import java.util.Objects;

//@javax.persistence.Entity
//@javax.persistence.Table(name = "victualer", schema = "carsystem", catalog = "")
@Data
public class SupplierEntity {
    // 供应商编号
    private String supplierId;
    // 供应商名称
    private String supplierName;
    // 供应商地址
    private String supplierAddress;
    // 供应商电话
    private String supplierTel;
    // 供应商开户行编号
    private String supplierBank;
    // 供应商账号
    private String supplierBankId;
    // 供应商备注
    private String supplierRemark;

//    @javax.persistence.Id
//    @javax.persistence.Column(name = "victualer_id")
//    public String getSupplierId() {
//        return supplierId;
//    }
//
//    public void setSupplierId(String victualerId) {
//        this.supplierId = victualerId;
//    }
//
//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "victualer_name")
//    public String getSupplierName() {
//        return supplierName;
//    }
//
//    public void setSupplierName(String victualerName) {
//        this.supplierName = victualerName;
//    }
//
//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "victualer_address")
//    public String getSupplierAddress() {
//        return supplierAddress;
//    }
//
//    public void setSupplierAddress(String victualerAddress) {
//        this.supplierAddress = victualerAddress;
//    }
//
//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "victualer_tel")
//    public String getSupplierTel() {
//        return supplierTel;
//    }
//
//    public void setSupplierTel(String victualerTel) {
//        this.supplierTel = victualerTel;
//    }
//
//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "victualer_bank")
//    public String getSupplierBank() {
//        return supplierBank;
//    }
//
//    public void setSupplierBank(String victualerBank) {
//        this.supplierBank = victualerBank;
//    }
//
//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "victualer_bank_id")
//    public String getSupplierBankId() {
//        return supplierBankId;
//    }
//
//    public void setSupplierBankId(String victualerBankId) {
//        this.supplierBankId = victualerBankId;
//    }
//
//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "victualer_remark")
//    public String getSupplierRemark() {
//        return supplierRemark;
//    }
//
//    public void setSupplierRemark(String victualerRemark) {
//        this.supplierRemark = victualerRemark;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierEntity that = (SupplierEntity) o;
        return Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(supplierAddress, that.supplierAddress) &&
                Objects.equals(supplierTel, that.supplierTel) &&
                Objects.equals(supplierBank, that.supplierBank) &&
                Objects.equals(supplierBankId, that.supplierBankId) &&
                Objects.equals(supplierRemark, that.supplierRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, supplierAddress, supplierTel, supplierBank, supplierBankId, supplierRemark);
    }
}
