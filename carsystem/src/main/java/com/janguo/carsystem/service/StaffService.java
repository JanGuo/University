package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.StaffEntity;

import java.util.List;

public interface StaffService {

    List<StaffEntity> getAllStaff();

    StaffEntity getStaffById(char a);

    boolean addStaff(StaffEntity staff);

    List<StaffEntity> getStaffsByDepartmentId(char id);
}
