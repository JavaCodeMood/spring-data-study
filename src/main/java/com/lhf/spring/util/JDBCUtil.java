package com.lhf.spring.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName: JDBCUtil
 * @Description:  JDBC工具类
 * @Author: liuhefei
 * @Date: 2019/8/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class JDBCUtil {

    /**
     * 获取Connection
     * @return 所获得到的JSDBC的Connection
     */
    public static Connection getConnection() throws Exception {
        /*String driverClassName = "com.mysql.jdbc.Driver";
        String url = "dbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "root";*/

        //读取配置文件
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        //加载InputStream
        properties.load(inputStream);
        String driverClassName  = properties.getProperty("jdbc.driverClass");
        String url  = properties.getProperty("jdbc.url");
        String username  = properties.getProperty("jdbc.username");
        String password  = properties.getProperty("jdbc.password");

        Class.forName(driverClassName);

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
