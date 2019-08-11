package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: EmployeeJpaSpecificationExecutorRepository
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/12
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {
}
