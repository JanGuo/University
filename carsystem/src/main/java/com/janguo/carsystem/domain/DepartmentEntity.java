package com.janguo.carsystem.domain;

import com.janguo.carsystem.vo.index.FindIndex;
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
    // TODO 公司新增员工 如何修改数据库信息
    private Integer staffNumber;
    // 公司管理员
    private String departmentManager;
    // 所有职工
    private List<StaffEntity> staffs;

    public static class Builder {
        private String departmentId;

        private String departmentName;
        private Integer staffNumber;
        private String departmentManager;


        public Builder(String departmentName, Integer staffNumber, String departmentManager) {
            this.departmentId = String.valueOf(FindIndex.departmentIndexNow.incrementAndGet());
            this.departmentName = departmentName;
            this.staffNumber = staffNumber;
            this.departmentManager = departmentManager;
        }


        public DepartmentEntity build() {
            return new DepartmentEntity(this);
        }

    }

    public DepartmentEntity() {

    }

    private DepartmentEntity(Builder builder) {
        this.departmentId = builder.departmentId;
        this.departmentName = builder.departmentName;
        this.staffNumber = builder.staffNumber;
        this.departmentManager = builder.departmentManager;
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
