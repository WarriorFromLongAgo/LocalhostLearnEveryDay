package com.day22_IO_SQL.day22homework.mysqldeal;

import com.day22_IO_SQL.day22homework.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class InsertToMysql {

    public void insertMysql(Map<Integer, Student> intStudentMap) {
        for (Map.Entry<Integer, Student> intStudentEntry : intStudentMap.entrySet()) {
            insertMysql(intStudentEntry.getValue());
        }
    }

    private void insertMysql(Student student) {
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
            String sql = "INSERT INTO day22homework(id, `name`, age, `classname`) VALUES" + " (" + student.getStudentId() +
                    ", '" + student.getStudentName() + "', " + student.getStudentAge() + ", '" + student.getStudentClassName()
                    + "')";
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
