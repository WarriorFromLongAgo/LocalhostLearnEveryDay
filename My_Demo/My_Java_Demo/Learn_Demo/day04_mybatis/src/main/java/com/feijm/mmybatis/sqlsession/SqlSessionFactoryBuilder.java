package com.feijm.mmybatis.sqlsession;

import com.feijm.mmybatis.cfg.Configuration;
import com.feijm.mmybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.feijm.mmybatis.util.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：
 * @more info   ：用于创建一个sqlSessionFactory对象
 * @more info   ：
 */
public class SqlSessionFactoryBuilder {
    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：根据参数的字节输入流，来构建一个SqlSessionFactory工厂
     * @more info   ：
     * @more info   ：
     */
    public SqlSessionFactory build(InputStream inputStream) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);

        return new DefaultSqlSessionFactory(configuration);
    }

}
