package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @ClassName: EmployeeJpaRepositoryTest
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/12
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        Optional<Employee> employee = employeeJpaRepository.findById(102);
        System.out.println(employee);


        System.out.println("employee(10): " + employeeJpaRepository.existsById(10));
        System.out.println("employee(150): " + employeeJpaRepository.existsById(150));
    }

}