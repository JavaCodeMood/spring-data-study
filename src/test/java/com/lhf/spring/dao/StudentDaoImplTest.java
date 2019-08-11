package com.lhf.spring.dao;

import com.lhf.spring.domain.Student;
import org.junit.Test;

import javax.swing.text.Style;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName: StudentDaoImplTest
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class StudentDaoImplTest {

    @Test
    public void save() {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("梦梦");
        student.setAge(22);
        student.setClassName("舞蹈一班");
        student.setPhone("18295514499");
        student.setAddress("中国香港");
        student.setCreateTime(new Date());

        studentDao.save(student);
    }

    @Test
    public void query() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.query();
        for(Student student : studentList){
            System.out.println(student.toString());
        }
    }
}