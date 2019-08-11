package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName: EmployeeCrudRepository
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
}
