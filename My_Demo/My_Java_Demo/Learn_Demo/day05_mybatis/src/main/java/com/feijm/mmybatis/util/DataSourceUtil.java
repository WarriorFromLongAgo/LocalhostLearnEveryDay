package com.feijm.mmybatis.util;

import com.feijm.mmybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {
    public static Connection getConnection(Configuration configuration) {

        try {
            Class.forName(configuration.getDriver());

            return DriverManager.getConnection(configuration.getUrl(),configuration.getUsername(),configuration.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("11111 DataSourceUtil" );
        } catch (SQLException e) {
            throw new RuntimeException("11111 DataSourceUtil" );
        }

    }
}
