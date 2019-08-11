package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName: EmployeeRepositoryTest
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testFindByName() {
        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@1a9c0566
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee.toString());
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 22);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }


    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee.toString());
    }

    @Test
    public void testQueryParams1() {
        List<Employee> employees = employeeRepository.queryParams1("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testQueryParams2() {
        List<Employee> employees = employeeRepository.queryParams2("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }


    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testQueryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testGetCount() {
        long count = employeeRepository.getCount();
        System.out.println("count:" + count);
    }

    @Test
    public void testGetCount1() {
        long count = employeeRepository.getCount1();
        System.out.println("count:" + count);
    }

    @Test
    public void testUpdate(){
        employeeRepository.update(2, 30);
    }

}