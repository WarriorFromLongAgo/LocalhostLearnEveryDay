package com.feijm.mmybatis.sqlsession;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：自定义mybatis中，数据库交互的核心类
 * @more info   ：它里面可以创建dao接口的代理对象
 * @more info   ：
 */
public interface SqlSession {
    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：根据参数创建一个，daoInterfaceClass 是dao接口的字节码对象
     * @more info   ：
     * @more info   ：
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
