package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.DepartmentEntity;
import com.janguo.carsystem.domain.StaffEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface DepartmentDao {


    @Results(id = "department",value = {
            @Result(property = "departmentId",column = "department_id"),
            @Result(property = "departmentName",column = "department_name"),
            @Result(property = "staffNumber",column = "staff_number"),
            @Result(property = "departmentManager",column = "department_manager"),
            @Result(property = "staffs" , column = "department_id",many = @Many(select = "com.janguo.carsystem.dao.StaffDao.getStaffsByDepartmentId",fetchType = FetchType.LAZY))
    })
    @Select("select * from department")
    List<DepartmentEntity> getAllDepartment();

    @ResultMap("department")
    @Select("select * from department where department_id=#{id}")
    DepartmentEntity getDepById(String id);


    @ResultMap("department")
    @Insert("insert into department(department_id,department_name,staff_number,department_manager) values(#{departmentId},#{departmentName},#{staffNumber},#{departmentManager})")
    boolean addDepartment(DepartmentEntity entity);

    @ResultMap("department")
    @Select("select staff_id,staff_name,department_name from staff as s inner join department as dep on s.department_id=#{departmentId}")
    List<StaffEntity> getSomeDepStaffsByDepId(DepartmentEntity department);




    @Select("SELECT count(*)  from department")
    int getIndex();
}
