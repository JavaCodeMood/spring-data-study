package com.lhf.spring.dao;

import com.lhf.spring.domain.Student;

import java.util.List;

/**
 * @ClassName: StudentDao
 * @Description: Student DAO接口
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public interface StudentDao {
    /**
     * 查询所有学生
     * @return
     */
    public List<Student> query();

    /**
     * 添加学生
     * @param student
     */
    public void save(Student student);


}
