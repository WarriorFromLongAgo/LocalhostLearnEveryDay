package com.day03_sql.sql2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            List<Emp> empList = findAll();
            System.out.println(empList.size());
            for (Emp emp : empList) {
                System.out.println(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<Emp> findAll() throws SQLException, ClassNotFoundException {
        List<Emp> empList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://127.0.0.1:3306/day0819" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8";
        String sqlUserName = "root";
        String sqlPassword = "123";


        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, sqlUserName, sqlPassword);
        System.out.println("数据连接成功");

        String sql = "SELECT * FROM emp";
        preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ename = resultSet.getString(2);
            double salary = resultSet.getDouble("salary");

            empList.add(new Emp(id, ename, salary));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return empList;

    }
}
