package com.feijm.mmybatis.sqlsession.proxy;

import com.feijm.mmybatis.cfg.Mapper;
import com.feijm.mmybatis.util.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    //    mappers的key是全限定类名 和 方法名
    private Map<String, Mapper> mappers;
    private Connection connection;


    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：用于对方法进行增强，我们的增强其实就是调用selectList方法
     * @more info   ：
     * @more info   ：
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        获取方法名称
        String methodName = method.getName();
//        获取方法所在类的名称。
        String className = method.getDeclaringClass().getName();
//        组合key
        String key = className + "." + methodName;
//        获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
//        判断是否有mapper对象
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
//        调用工具类查询所有


        return new Executor().selectList(mapper, connection);
    }
}
