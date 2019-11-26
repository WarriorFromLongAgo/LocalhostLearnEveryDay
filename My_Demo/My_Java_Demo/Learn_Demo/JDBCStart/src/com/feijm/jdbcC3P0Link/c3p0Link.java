//package com.feijm.jdbcC3P0Link;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class c3p0Link {
//    public static void main(String[] args) {
//        DataSource comboPooledDataSource = new ComboPooledDataSource();
//
//        try {
//            Connection connection = comboPooledDataSource.getConnection();
//
//            String sql = "update student set age = age + 1 where NAME = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "苍井空");
//            int count = preparedStatement.executeUpdate();
//
//            System.out.println("修改成功，次数为 = " + count);
//
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
