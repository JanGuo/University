package com.janguo.carsystem.domain;

import lombok.Data;


import java.util.List;
import java.util.Objects;


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
