package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.StaffEntity;
import com.janguo.carsystem.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StaffServiceImplTest {


    @Autowired
    StaffService staffService;
    @Test
    void getAllStaffTest() {
        System.out.println(staffService.getAllStaff());
    }


    @Test
    void getStaffTest() {
        System.out.println(staffService.getStaffById('1'));
    }

    @Test
    void addStaff() {
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setStaffId("3");
        staffEntity.setStaffName("周五");
        staffEntity.setStaffAddress("杭州");
        staffEntity.setDepartmentId("1");
        staffEntity.setStaffTel("1008611");
        staffEntity.setStaffBank("建设");
        staffEntity.setStaffBankId("123456");

        assertTrue(staffService.addStaff(staffEntity));

    }

    @Test
    void getStaffsByDepartmentId() {
        System.out.println(staffService.getStaffsByDepartmentId('1'));
    }
}