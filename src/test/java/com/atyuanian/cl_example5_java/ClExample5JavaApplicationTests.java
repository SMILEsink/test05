package com.atyuanian.cl_example5_java;

import com.atyuanian.cl_example5_java.Entity.Department;
import com.atyuanian.cl_example5_java.Entity.Employee;
import com.atyuanian.cl_example5_java.Schedule.ScheduledTasks;
import com.atyuanian.cl_example5_java.Service.EmployeeService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClExample5JavaApplicationTests {

    @Autowired
    ScheduledTasks scheduledTasks;



//    @Ignore
//    @Test
//    public void contextLoads() throws ParseException {
//        scheduledTasks.reportCurrentByCron();
//        for (int i=0;;i++){
//
//        }
//    }

    @Autowired
    private EmployeeService employeeService;
    @Ignore
    @Test
    public void TestInsert(){
        Department department = new Department();
        department.setDepartmentname("武汉技术开发部");
        department.setId(1);

        Employee employee=new Employee();
        employee.setDepartment(department);
        employee.setUsercode(1001);
        employee.setUsername("李四");
        System.out.println(employee);
        employeeService.InsertEmployee(employee);
    }


    @Test
    public void findEmployee(){
//        System.out.println(employeeService.GetEmployeeByUsercode(10010));
        System.out.println(employeeService.findEmployeesByDate("2019-08-29","2019-08-30"));
    }

}
