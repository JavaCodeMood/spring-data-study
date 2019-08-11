package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import com.lhf.spring.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName: EmployeeCrudRepositoryTest
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class EmployeeCrudRepositoryTest {


    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testSave(){
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = null;
        for(int i=0;i<100;i++){
            employee = new Employee();
            employee.setName("tom"+i);
            employee.setAge(100-i);
            employee.setPhone("18396613304");
            employee.setCreateTime(new Date());
            employeeList.add(employee);
        }
        employeeService.save(employeeList);
    }


}