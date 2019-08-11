package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.Assert.*;

/**
 * @ClassName: EmployeePagingAndSortingRespsitoryTest
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/12
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class EmployeePagingAndSortingRespsitoryTest {

    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRespsitory employeePagingAndSortingRespsitory = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRespsitory = ctx.getBean(EmployeePagingAndSortingRespsitory.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testPage(){
        //page: index从0开始
        Pageable pageable = new PageRequest(0, 10);  //第0页，每页10条
        Page<Employee> page = employeePagingAndSortingRespsitory.findAll(pageable);
        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前第几页：" + (page.getNumber()+1));
        System.out.println("查询的当前页面的集合：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());
    }


    @Test
    public void testPageAndSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");  //根据id降序排序
        Sort sort = new Sort(order);
        //page: index从0开始
        Pageable pageable = new PageRequest(1, 10, sort);  //第1页，每页10条
        Page<Employee> page = employeePagingAndSortingRespsitory.findAll(pageable);
        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前第几页：" + (page.getNumber()+1));
        System.out.println("查询的当前页面的集合：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());
    }
}