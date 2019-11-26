package com.fff.util;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @PackageName：com.fff.util
 * @ClassName：获取 线程单一的连接池
 * @Description：
 * @author：
 * @date：2019/10/21 11:25
 */
@Component(value = "connectionUtil")
public class ConnectionUtil {

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
//        1，先从当前线程上获取
        Connection connection = connectionThreadLocal.get();
//        2，判断当前线程是否有连接
        if (connection == null) {
//            3，如果为空，就从数据源中获取一个连接，并且和线程绑定，存入ThreadConnection
            try {
                connection = dataSource.getConnection();
                connectionThreadLocal.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//        返回连接
        return connection;
    }

    
    /**
     * @Author 
     * @Description 
     * @Date 2019/10/21 12:00 
     * @Param 把链接和线程解绑
     * @return
     **/
    public void removeConnection() {
        connectionThreadLocal.remove();
    }

}
