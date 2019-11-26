package com.feijm.jdbcutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtilDruid {
    private static Connection connection = null;
    private static DataSource dataSource = null;

    static {
        try {

            ClassLoader classLoader = jdbcUtilDruid.class.getClassLoader();
            Properties properties = new Properties();
            URL resource = classLoader.getResource("druid.properties");
            String path = resource.getPath();
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

    @SuppressWarnings("all")
    public static void closeMysql(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("all")
    public static void closeMysql(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
