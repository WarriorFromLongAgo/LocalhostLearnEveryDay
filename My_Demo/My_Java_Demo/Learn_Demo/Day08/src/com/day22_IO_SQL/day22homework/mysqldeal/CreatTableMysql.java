package com.day22_IO_SQL.day22homework.mysqldeal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatTableMysql {
    public void creatTable() {
        Connection connection = null;
        Statement statement = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sqltestone" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8";
        String sqlUserName = "root";
        String sqlPassWord = "123";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, sqlUserName, sqlPassWord);
            if (connection != null) {
                System.out.println(" 数据库连接成功 ");
            }
            //  二，对数据库进行增删改的操作
            //  1，通过connection创建Statement对象
            statement = connection.createStatement();
            //  Statement，sql语句的发送器，向数据库发送sql语句，
            //  调用
            String sql = "create table day22homework(" +
                    "id INT NOT NULL PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INT," +
                    "classname VARCHAR(50))";
//            String sql2 = "INSERT INTO Constructor(`name`, id, age) VALUES ('student10', 35, 22)";
//            String sql = "UPDATE Constructor SET Constructor.`name` = 'student11' WHERE Constructor.id = 11";
//            String sql = "DELETE FROM Constructor WHERE Constructor.id=35";
            int count = statement.executeUpdate(sql);
            System.out.println("此条sql语句影响的行数 = " + count);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            TestMysql.closeMysql(connection, statement);

        }
    }
}
