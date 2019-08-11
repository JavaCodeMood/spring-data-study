package com.lhf.spring.service;

import com.lhf.spring.domain.Employee;
import com.lhf.spring.repository.EmployeeCrudRepository;
import com.lhf.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: EmployeeService
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    /**
     * 更新事务
     * @param id
     * @param age
     */
    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }

    @Transactional
    public void save(List<Employee> employeeList){
        employeeCrudRepository.saveAll(employeeList);
    }
}
