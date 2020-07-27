package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.DepartmentEntity;
import com.janguo.carsystem.domain.StaffEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getAllDepartment();

    boolean addDepartment(DepartmentEntity entity);

    List<StaffEntity> getSomeDepStaffsByDepId(DepartmentEntity entity);

    DepartmentEntity getDepById(String id);
}
