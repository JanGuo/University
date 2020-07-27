package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.StaffDao;
import com.janguo.carsystem.domain.StaffEntity;
import com.janguo.carsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;

    @Override
    public List<StaffEntity> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public StaffEntity getStaffById(char a) {
        return staffDao.getStaffById(a);
    }

    @Override
    public boolean addStaff(StaffEntity staff) {
        return staffDao.addStaff(staff);
    }

    @Override
    public List<StaffEntity> getStaffsByDepartmentId(char id) {
        return staffDao.getStaffsByDepartmentId(id);
    }
}
