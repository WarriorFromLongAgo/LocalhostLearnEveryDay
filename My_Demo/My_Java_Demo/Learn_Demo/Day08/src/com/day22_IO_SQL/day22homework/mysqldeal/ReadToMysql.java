package com.day22_IO_SQL.day22homework.mysqldeal;

import java.sql.*;

public class ReadToMysql {
    public void readToMysql() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

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
            String sql = "SELECT * FROM day22homework";

            resultSet = statement.executeQuery(sql);
            int count = resultSet.getMetaData().getColumnCount();
            String tempid = "id";
            while (resultSet.next()) {
//                System.out.println(resultSet.getString(tempid));
//                System.out.print(resultSet.getString(1) + ",");
//                System.out.print(resultSet.getString(2) + ",");
//                System.out.print(resultSet.getString(3) + ",");
//                System.out.println(resultSet.getString(4));


                for (int i = 1; i <= count; i++) {
                    System.out.print(resultSet.getString(i));
                    if (i < count) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            TestMysql.closeMysql(connection, statement, resultSet);

        }
    }
}
