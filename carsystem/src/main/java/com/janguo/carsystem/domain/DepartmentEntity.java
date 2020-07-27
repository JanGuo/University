package com.janguo.carsystem.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

//@javax.persistence.Entity
//@javax.persistence.Table(name = "department", schema = "carsystem", catalog = "")
@Data
public class DepartmentEntity {
    // 公司编号
    private String departmentId;
    // 公司名称
    private String departmentName;
    // 职工数目
    private Integer staffNumber;
    // 公司管理员
    private String departmentManager;
    // 所有职工
    private List<StaffEntity> staffs;

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", staffNumber=" + staffNumber +
                ", departmentManager='" + departmentManager + '\'' +
                ", staffs=" + staffs +
                '}';
    }


    public List<StaffEntity> getStaffs() {
        return staffs;
    }
//
//    @javax.persistence.Id
//    @javax.persistence.Column(name = "department_id")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "staff_number")
    public Integer getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(Integer staffNumber) {
        this.staffNumber = staffNumber;
    }

//    @javax.persistence.Basic
//    @javax.persistence.Column(name = "department_manager")
    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(staffNumber, that.staffNumber) &&
                Objects.equals(departmentManager, that.departmentManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, staffNumber, departmentManager);
    }
}
