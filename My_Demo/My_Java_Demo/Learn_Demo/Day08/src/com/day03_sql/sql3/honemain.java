package com.day03_sql.sql3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class honemain {
    public static void main(String[] args) {
//        deleteDemo();
//        List<Student> studentList = selectDemo();
//        for (Student demo4 : studentList) {
//            System.out.println(demo4);
//        }
        deleteDemo();
    }

    private static List<Student> selectDemo() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtil.getConnection();
            if (!connection.isClosed()) {
                System.out.println("连接成功");
            }
            String sql = "select * from student;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                int math = resultSet.getInt("math");
                int english = resultSet.getInt("english");
                studentList.add(new Student(id, name, age, sex, address, math, english));
//                for (int i = 0; i <= columnCount; i++) {
//
//                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeMysql(connection, preparedStatement, resultSet);
        }
        return studentList;
    }

    private static void deleteDemo() {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/day0819" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8" +
                "&useServerPrepStmts=true&cachePrepStmts=true";
        String sqlUserName = "root";
        String sqlPassWord = "123";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, sqlUserName, sqlPassWord);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
            }
            connection.setAutoCommit(false);

            String sql1 = "update student set math = math + 10 where NAME = ?";
            String sql2 = "update student set english = english - 10 where NAME = ?";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);

            preparedStatement1.setString(1, "苍井空");
            preparedStatement2.setString(1, "苍井空");

            int count1 = preparedStatement1.executeUpdate();
            int count2 = preparedStatement2.executeUpdate();
            System.out.println("提交成功");
            connection.commit();
            System.out.println("修改了 = " + count1 + "次");

        } catch (ClassNotFoundException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement2 != null) {
                try {
                    preparedStatement2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

//            if (preparedStatement2 != null) {
//                try {
//                    preparedStatement2.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (preparedStatement2 != null) {
//                try {
//                    preparedStatement2.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            JDBCUtil.closeMysql(connection, preparedStatement1, resultSet);
        }
    }
}
