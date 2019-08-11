package com.lhf.spring.repository;

import com.lhf.spring.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @ClassName: EmployeeRepository
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository { //extends Repository<Employee,Integer>{

    public Employee findByName(String name);

    /**
     * 查询以name开头，小于age的数据
     * @param name
     * @param age
     * @return
     */
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    /**
     * 查询以name结尾，小于age的数据
     * @param name
     * @param age
     * @return
     */
    public List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    /**
     * 查询多个name或小于age的数据
     * @param name
     * @param age
     * @return
     */
    public List<Employee> findByNameInOrAgeLessThan(List<String> name, Integer age);

    /**
     * 查询多个name并且小于age的数据
     * @param name
     * @param age
     * @return
     */
    public List<Employee> findByNameInAndAgeLessThan(List<String> name, Integer age);

    /**
     * 查询id最大的数据
     * @return
     */
    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    public Employee getEmployeeByMaxId();

    /**
     * 根据name和age查询所有匹配的数据
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public List<Employee> queryParams1(String name, Integer age);

    /**
     * 根据name或age查询所有匹配的数据
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=:name or o.age=:age")
    public List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 根据name进行like查询
     * @param name
     * @return
     */
    @Query("select o from Employee o where o.name like %?1%")
    public List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    public List<Employee> queryLike2(@Param("name")String name);

    /**
     * 查询总的记录条数
     * @return
     */
    @Query("select count(*) from Employee")
    public long getCount();

    @Query(nativeQuery = true, value = "select count(1) from Employee")
    public long getCount1();

    /**
     * 根据id更新年龄
     * @param id
     * @param age
     */
    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    public void update(@Param("id")Integer id, @Param("age")Integer age);
}
