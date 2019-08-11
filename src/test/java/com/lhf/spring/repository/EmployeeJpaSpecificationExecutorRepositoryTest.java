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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName: EmployeeJpaSpecificationExecutorRepositoryTest
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/12
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    /**
     * 1. 分页
     * 2. 排序
     * 3. 查询条件：age > 50
     */
    @Test
    public void testQuery(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");  //根据id降序排序
        Sort sort = new Sort(order);
        //page: index从0开始
        Pageable pageable = new PageRequest(1, 10, sort);  //第1页，每页10条

        //root: 就是我们要查询的类型，这里时Employee
        //query: 添加查询条件
        //criteriaBuilder： 构建Predicate
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query, //查询条件
                                         CriteriaBuilder criteriaBuilder) {
                //root(employee(age))
                Path path = root.get("age");

                return  criteriaBuilder.gt(path, 50);  //年龄大于50;
            }
        };
        List<Employee> employeeList = employeeJpaSpecificationExecutorRepository.findAll(specification, sort);
        System.out.println("employeeList = " + employeeList);

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(pageable);
        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数：" + page.getTotalElements());
        System.out.println("查询的当前第几页：" + (page.getNumber()+1));
        System.out.println("查询的当前页面的集合：" + page.getContent());
        System.out.println("查询的当前页面的记录数：" + page.getNumberOfElements());

    }


}