package com.feijm.mmybatis.sqlsession.defaults;

import com.feijm.mmybatis.cfg.Configuration;
import com.feijm.mmybatis.sqlsession.SqlSession;
import com.feijm.mmybatis.sqlsession.proxy.MapperProxy;
import com.feijm.mmybatis.util.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：SqlSession接口的实现类
 * @more info   ：
 * @more info   ：
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration inputConfiguration) {
        this.configuration = inputConfiguration;
        connection = DataSourceUtil.getConnection(inputConfiguration);
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：用于创建代理对象
     * @more info   ：
     * @more info   ：
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {


        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(configuration.getMappers(), connection));
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：用于释放资源
     * @more info   ：
     * @more info   ：
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
