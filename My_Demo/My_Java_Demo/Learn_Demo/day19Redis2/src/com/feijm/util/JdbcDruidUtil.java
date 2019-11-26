package com.feijm.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

public class JdbcDruidUtil {
    private static Connection connection;
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            URL resource = JdbcDruidUtil.class.getClassLoader().getResource("druid.properties");
            String path = resource.getPath();
            System.out.println(path);
            properties.load(new FileReader(path));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
