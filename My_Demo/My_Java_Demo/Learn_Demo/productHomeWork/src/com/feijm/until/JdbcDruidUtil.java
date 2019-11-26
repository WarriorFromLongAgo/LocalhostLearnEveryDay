package com.feijm.until;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：
 * @more info   ：
 * @more info   ：
 */
public class JdbcDruidUtil {
    private static Connection connection = null;
    private static DataSource dataSource = null;

    static {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = JdbcDruidUtil.class.getClassLoader();
            URL resource = classLoader.getResource("druid.properties");
            String path = null;
            if (resource != null) {
                path = resource.getPath();
            } else {
                throw new RuntimeException("resource = null，请排查路径检测");
            }
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

//    public static void closeMysql(Connection connection) {
//
//    }
}
