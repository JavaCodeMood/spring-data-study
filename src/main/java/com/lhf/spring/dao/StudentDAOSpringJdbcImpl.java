package com.lhf.spring.dao;

import com.lhf.spring.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: StudentDAOSpringJdbcImpl
 * @Description:StudentDao接口实现类: 通过Spring JDBC的方式操作
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class StudentDAOSpringJdbcImpl implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> query() {
        final List<Student> studentList = new ArrayList<Student>();
        String sql = "select * from student";
        jdbcTemplate.query(sql, new RowCallbackHandler(){

            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String className = rs.getString("class_name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date createTime = rs.getTime("create_time");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setClassName(className);
                student.setPhone(phone);
                student.setAddress(address);
                student.setCreateTime(createTime);

                studentList.add(student);
            }
        });
        return studentList;
    }

    public void save(Student student) {
        String sql = "insert into student(name, age, class_name, phone, address, create_time) values (?, ?, ?, ?, ?, ?) ";

        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge(), student.getClassName(), student.getPhone(), student.getAddress(), student.getCreateTime()});

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
