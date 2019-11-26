package com.fff.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/21 12:02
 */

public class DruidTest {



    @Test
    public void druidTest1(){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springboot1" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        try {
            connection = dataSource.getConnection();
            System.out.println(connection);
            System.out.println(dataSource.getClass());
            System.out.println(dataSource.getName());

//            String sql = "select * from day22homework";
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("id") + "   " + resultSet.getString("name"));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
