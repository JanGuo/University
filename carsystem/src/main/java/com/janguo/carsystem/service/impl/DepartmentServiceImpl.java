package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.DepartmentDao;
import com.janguo.carsystem.domain.DepartmentEntity;
import com.janguo.carsystem.domain.StaffEntity;
import com.janguo.carsystem.service.DepartmentService;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    DepartmentDao departmentDao;
    @Override
    public List<DepartmentEntity> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public boolean addDepartment(DepartmentEntity entity) {
        return departmentDao.addDepartment(entity);
    }

    @Override
    public List<StaffEntity> getSomeDepStaffsByDepId(DepartmentEntity entity) {
        return departmentDao.getSomeDepStaffsByDepId(entity);
    }

    @Override
    public DepartmentEntity getDepById(String id) {
        return departmentDao.getDepById(id);
    }
}
