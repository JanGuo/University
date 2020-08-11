package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.domain.DepartmentEntity;
import com.janguo.carsystem.domain.StaffEntity;
import com.janguo.carsystem.service.DepartmentService;
import com.janguo.carsystem.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    StaffService staffService;

    @Test
    void testGetAllDepartment() {
        System.out.println(departmentService.getAllDepartment());
    }

    @Test
    void testAddDepartment() {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentId("1");
        entity.setDepartmentName("美团");
        entity.setStaffNumber(1);
        entity.setDepartmentManager("admin");
        assertTrue(departmentService.addDepartment(entity));
    }


    @Test
    void testGetDepAllStaff() {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentId("1");
        System.out.println(departmentService.getSomeDepStaffsByDepId(entity));
    }

    @Test
    void testGetDepById() {
        System.out.println(departmentService.getDepById("2"));
    }

    @Test
    void testGetDepAllStaff2() {
        List<DepartmentEntity> allDepartment = departmentService.getAllDepartment();
        for (DepartmentEntity deparment : allDepartment) {
//            System.out.println(Department);
            System.out.println(deparment);
            List<StaffEntity> staffs = deparment.getStaffs();
            staffs.stream().map(staffEntity -> staffEntity.getStaffName()).forEach(System.out::println);
            staffs.stream().forEach(System.out::println);

        }

    }

    @Test
    void testDepartmentBuilder() {
        DepartmentEntity departmentEntity = new DepartmentEntity.Builder("阿里巴巴", 1200, "maYun").build();
        assertTrue(departmentService.addDepartment(departmentEntity));
    }
}