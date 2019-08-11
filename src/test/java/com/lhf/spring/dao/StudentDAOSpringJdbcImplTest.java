package com.lhf.spring.dao;

import com.lhf.spring.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class StudentDAOSpringJdbcImplTest {


    private ApplicationContext ctx = null;
    private StudentDao studentDao = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao)ctx.getBean("studentDao");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testQuery() {
        List<Student> students = studentDao.query();

        for (Student student : students) {
            System.out.println(student.toString());
        }

    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("依依");
        student.setAge(22);
        student.setClassName("舞蹈二班");
        student.setPhone("18295514488");
        student.setAddress("中国香港");
        student.setCreateTime(new Date());

        studentDao.save(student);
    }

}
