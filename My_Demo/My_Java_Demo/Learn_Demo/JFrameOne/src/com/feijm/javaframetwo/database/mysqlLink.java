package com.feijm.javaframetwo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因:
 */
public class mysqlLink {
    public static void main(String[] args) {
        Connection connection = null;
        //  jdbc驱动
        String diver = "com.mysql.cj.jdbc.Driver";
        //String diver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sqltestone" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
        String sqlUserName = "root";
        String sqlPassword = "123";

        try {
            //  注册驱动
            Class.forName(diver);
            System.out.println("加载驱动成功");
            connection = DriverManager.getConnection(url, sqlUserName, sqlPassword);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("没有安装数据库驱动");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
