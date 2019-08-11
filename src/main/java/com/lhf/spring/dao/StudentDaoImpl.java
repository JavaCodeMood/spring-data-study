package com.lhf.spring.dao;

import com.lhf.spring.domain.Student;
import com.lhf.spring.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: StudentDaoImpl
 * @Description: StudentDao接口实现类: 通过最原始的JDBC的方式操作
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class StudentDaoImpl implements StudentDao {

    public List<Student> query() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Student> studentList = new ArrayList<Student>();
        String sql = "select * from student";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student = null;
            while ((resultSet.next())){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String className = resultSet.getString("class_name");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Date createTime = resultSet.getTime("create_time");

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setClassName(className);
                student.setPhone(phone);
                student.setAddress(address);
                student.setCreateTime(createTime);

                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
        return studentList;
    }

    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Student> studentList = new ArrayList<Student>();
        String sql = "insert into student(name, age, class_name, phone, address, create_time) values (?, ?, ?, ?, ?, ?) ";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getClassName());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setDate(6, (java.sql.Date) student.getCreateTime());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
    }
}
