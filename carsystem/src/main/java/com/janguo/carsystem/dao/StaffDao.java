package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.StaffEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface StaffDao {
    @Results(id = "staff",value = { //2
            @Result(property = "staffId", column = "staff_id"), //2column —>数据库  property—>类属性
            @Result(property = "departmentId", column = "department_id"),
            @Result(property = "staffName", column = "staff_name"),
            @Result(property = "staffAddress", column = "staff_address"),
            @Result(property = "staffTel", column = "staff_tel"),
            @Result(property = "staffBank", column = "staff_bank"),
            @Result(property = "staffBankId", column = "staff_bank_id"),
            @Result(property = "department",column = "department_id",one = @One(select = "com.janguo.carsystem.dao.DepartmentDao.getDepById",fetchType = FetchType.EAGER))
    })
    @Select("select * from staff")
    List<StaffEntity> getAllStaff();

    @ResultMap("staff")
    @Select("select * from staff where staff_id=#{id}")
    StaffEntity getStaffById(char id);

    @ResultMap("staff")
    @Insert("insert into staff(staff_id,department_id,staff_name,staff_address,staff_tel,staff_bank,staff_bank_id) values(#{staffId},#{departmentId},#{staffName},#{staffAddress},#{staffTel},#{staffBank},#{staffBankId})")
    boolean addStaff(StaffEntity staff);

    @ResultMap("staff")
    @Select("Select * from staff where department_id=#{id}")
    List<StaffEntity> getStaffsByDepartmentId(char id);
}
