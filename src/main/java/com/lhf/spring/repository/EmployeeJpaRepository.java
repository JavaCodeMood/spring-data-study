package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: EmployeeJpaRepository
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/12
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
