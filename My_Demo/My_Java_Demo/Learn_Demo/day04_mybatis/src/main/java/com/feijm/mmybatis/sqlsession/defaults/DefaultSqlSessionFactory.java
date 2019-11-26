package com.feijm.mmybatis.sqlsession.defaults;

import com.feijm.mmybatis.cfg.Configuration;
import com.feijm.mmybatis.sqlsession.SqlSession;
import com.feijm.mmybatis.sqlsession.SqlSessionFactory;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：SqlSessionFactory接口的实现类
 * @more info   ：
 * @more info   ：
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration inputconfiguration) {
        this.configuration = inputconfiguration;
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：用于创建一个新的操作数据库对象
     * @more info   ：
     * @more info   ：
     */
    public SqlSession openSession() {


        return new DefaultSqlSession(configuration);
    }
}
