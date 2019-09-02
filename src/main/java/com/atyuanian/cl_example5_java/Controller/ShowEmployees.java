package com.atyuanian.cl_example5_java.Controller;

import com.atyuanian.cl_example5_java.Entity.Employee;
import com.atyuanian.cl_example5_java.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ShowEmployees {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("showemployee/{usercode}")
    public Employee ShowEmployeeByUsercode(@PathVariable("usercode") Integer usercode){
        System.out.println(usercode);
        Employee employee = employeeService.GetEmployeeByUsercode(usercode);
        return employee;
    }


    @PostMapping("getdata")
    public List<Employee> ShowEmployeesByDate(@RequestParam("startTime") String startTime,@RequestParam("lastTime") String lastTime){
        List<Employee> employees = employeeService.findEmployeesByDate(startTime,lastTime);
        return  employees;
    }
}
