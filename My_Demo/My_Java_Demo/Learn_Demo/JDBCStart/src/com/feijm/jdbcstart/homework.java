package com.feijm.jdbcstart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class homework {
    public static void main(String[] args) {
//        deleteDemo();
        List<Student> studentList = selectDemo();
        for (Student student : studentList) {
            System.out.println(student);
        }
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
}
