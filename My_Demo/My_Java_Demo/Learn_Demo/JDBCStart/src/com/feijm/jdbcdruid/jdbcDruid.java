package com.feijm.jdbcdruid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class jdbcDruid {
    public static void main(String[] args) {

        try {
            ClassLoader classLoader = jdbcDruid.class.getClassLoader();
            Properties properties = new Properties();
            URL resource = classLoader.getResource("druid.properties");
            String path = resource.getPath();
            properties.load(new FileReader(path));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();

            String sql = "update student set age = age + 1 where NAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "苍井空");
            int count = preparedStatement.executeUpdate();

            System.out.println("修改成功，次数为 = " + count);

            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
