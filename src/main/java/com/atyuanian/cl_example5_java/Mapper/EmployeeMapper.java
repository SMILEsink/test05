package com.atyuanian.cl_example5_java.Mapper;

import com.atyuanian.cl_example5_java.Entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectByUsercode(Integer usercode);

    @Select("select id from department where departmentname")
    int selectidByName(String departmentname);

//    @Select("select * from employee where hiredate >= #{startTime} and hiredate < #{lastTime}")
    List<Employee> findEmployeesByDate(String startTime,String lastTime);
}