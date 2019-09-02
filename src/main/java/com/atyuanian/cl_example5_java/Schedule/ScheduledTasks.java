package com.atyuanian.cl_example5_java.Schedule;


import com.atyuanian.cl_example5_java.Entity.Department;
import com.atyuanian.cl_example5_java.Entity.Employee;
import com.atyuanian.cl_example5_java.Service.EmployeeService;
import com.atyuanian.cl_example5_java.Util.PureNetUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks{

    @Autowired
    EmployeeService employeeService;
    //每1分钟执行一次
//    @Scheduled(cron = "*/30 * * * * ?")
//    在每天凌晨一点执行
    @Scheduled(cron = "0 0 1 * * ?")
    public void reportCurrentByCron() throws ParseException {

        String url="http://192.168.51.78:8080/getdata";
        Map<String,Object> map = new HashMap<>();
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);
        String startTime = new java.sql.Date(calendar.getTime().getTime()).toString();
        String lastTime = new java.sql.Date(new Date().getTime()).toString();
//        将util.date强转为sql.date
//        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        map.put("startTime",startTime);
        map.put("lastTime",lastTime);
        //请求调用接口
        String content=PureNetUtil.post(url,map);
        //解析返回过来的json值；
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Employee> employeeList = new ArrayList<>();
        JSONArray jsonArray = JSONArray.fromObject(content);
        for(int i=0;i<jsonArray.size();i++){

            JSONObject json = jsonArray.getJSONObject(i);
            Employee employee = new Employee();
            Department department = new Department();
            Date date=sdf.parse(json.getString("hiredate"));
            employee.setUsername(json.getString("username"));
            employee.setUsercode(Integer.parseInt(json.getString("usercode")));
            department.setDepartmentname(json.getString("department"));
//            employee.setDepartment(json.getString("department"));
            employee.setHiredate(new java.sql.Date(date.getTime()));
            employeeList.add(employee);
            System.out.println("哈哈哈"+employee);
            int departmentid = employeeService.selectIdByName(employee.getDepartment().getDepartmentname());

            department.setId(departmentid);
            employee.setDepartment(department);
            employeeService.InsertEmployee(employee);
        }
        System.out.println("哈哈哈1"+employeeList);



    }
}