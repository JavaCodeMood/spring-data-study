package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @ClassName: EmployeePagingAndSortingRespsitory
 * @Description: PagingAndSortingRepository支持分页和排序
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public interface EmployeePagingAndSortingRespsitory extends PagingAndSortingRepository<Employee, Integer> {

}
