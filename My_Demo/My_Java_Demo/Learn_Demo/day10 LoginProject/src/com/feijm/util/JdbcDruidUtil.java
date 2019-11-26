package com.feijm.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDruidUtil {

    private static Connection connection;
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
//            InputStream resourceAsStream = JdbcDruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
//            properties.load(resourceAsStream);
            ClassLoader classLoader = JdbcDruidUtil.class.getClassLoader();
            URL resource = classLoader.getResource("druid.properties");
            String path = resource.getPath();
            properties.load(new FileReader(path));
            System.out.println(path);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
