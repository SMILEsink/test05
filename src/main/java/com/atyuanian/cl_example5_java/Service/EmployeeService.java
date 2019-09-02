package com.atyuanian.cl_example5_java.Service;

import com.atyuanian.cl_example5_java.Entity.Employee;
import com.atyuanian.cl_example5_java.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    public void InsertEmployee(Employee employee){
        employeeMapper.insert(employee);
    }
    public Employee GetEmployeeByUsercode(Integer usercode){
        Employee employee = new Employee();
        employee = employeeMapper.selectByUsercode(usercode);
        return employee;
    }

    public List<Employee> findEmployeesByDate(String startTime,String lastTime){

        List<Employee> employees= new ArrayList<>();
        employees= employeeMapper.findEmployeesByDate(startTime,lastTime);
        return  employees;
    }

    public int selectIdByName(String Name){
        return employeeMapper.selectidByName(Name);
    }

}
