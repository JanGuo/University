package com.janguo.carsystem.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

//@javax.persistence.Entity
//@javax.persistence.Table(name = "staff", schema = "carsystem")
@Data
public class StaffEntity {
    // 员工编号
    private String staffId;
    // 公司编号
    private String departmentId;
    // 员工姓名
    private String staffName;
    // 员工地址
    private String staffAddress;
    // 员工电话
    private String staffTel;
    // 员工开户行
    private String staffBank;
    // 员工账号
    private String staffBankId;
    // 所属公司
    @ToString.Exclude
    private DepartmentEntity department;

//    @javax.persistence.Id
//    @javax.persistence.Column(name = "staff_id")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "department_id")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "staff_address")
    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "staff_tel")
    public String getStaffTel() {
        return staffTel;
    }

    public void setStaffTel(String staffTel) {
        this.staffTel = staffTel;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "staff_bank")
    public String getStaffBank() {
        return staffBank;
    }

    public void setStaffBank(String staffBank) {
        this.staffBank = staffBank;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "staff_bank_id")
    public String getStaffBankId() {
        return staffBankId;
    }

    public void setStaffBankId(String staffBankId) {
        this.staffBankId = staffBankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return Objects.equals(staffId, that.staffId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(staffName, that.staffName) &&
                Objects.equals(staffAddress, that.staffAddress) &&
                Objects.equals(staffTel, that.staffTel) &&
                Objects.equals(staffBank, that.staffBank) &&
                Objects.equals(staffBankId, that.staffBankId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, departmentId, staffName, staffAddress, staffTel, staffBank, staffBankId);
    }

}
