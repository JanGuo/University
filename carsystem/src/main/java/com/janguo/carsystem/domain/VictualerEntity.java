package com.janguo.carsystem.domain;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "victualer", schema = "carsystem", catalog = "")
public class VictualerEntity {
    // 供应商编号
    private String victualerId;
    // 供应商名称
    private String victualerName;
    // 供应商地址
    private String victualerAddress;
    // 供应商电话
    private String victualerTel;
    // 供应商开户行编号
    private String victualerBank;
    // 供应商账号
    private String victualerBankId;
    // 供应商备注
    private String victualerRemark;

    @javax.persistence.Id
    @javax.persistence.Column(name = "victualer_id")
    public String getVictualerId() {
        return victualerId;
    }

    public void setVictualerId(String victualerId) {
        this.victualerId = victualerId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_name")
    public String getVictualerName() {
        return victualerName;
    }

    public void setVictualerName(String victualerName) {
        this.victualerName = victualerName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_address")
    public String getVictualerAddress() {
        return victualerAddress;
    }

    public void setVictualerAddress(String victualerAddress) {
        this.victualerAddress = victualerAddress;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_tel")
    public String getVictualerTel() {
        return victualerTel;
    }

    public void setVictualerTel(String victualerTel) {
        this.victualerTel = victualerTel;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_bank")
    public String getVictualerBank() {
        return victualerBank;
    }

    public void setVictualerBank(String victualerBank) {
        this.victualerBank = victualerBank;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_bank_id")
    public String getVictualerBankId() {
        return victualerBankId;
    }

    public void setVictualerBankId(String victualerBankId) {
        this.victualerBankId = victualerBankId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "victualer_remark")
    public String getVictualerRemark() {
        return victualerRemark;
    }

    public void setVictualerRemark(String victualerRemark) {
        this.victualerRemark = victualerRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VictualerEntity that = (VictualerEntity) o;
        return Objects.equals(victualerId, that.victualerId) &&
                Objects.equals(victualerName, that.victualerName) &&
                Objects.equals(victualerAddress, that.victualerAddress) &&
                Objects.equals(victualerTel, that.victualerTel) &&
                Objects.equals(victualerBank, that.victualerBank) &&
                Objects.equals(victualerBankId, that.victualerBankId) &&
                Objects.equals(victualerRemark, that.victualerRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(victualerId, victualerName, victualerAddress, victualerTel, victualerBank, victualerBankId, victualerRemark);
    }
}
