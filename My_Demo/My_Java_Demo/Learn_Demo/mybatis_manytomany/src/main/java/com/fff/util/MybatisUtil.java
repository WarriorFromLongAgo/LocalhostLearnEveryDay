package com.fff.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @PackageName：com.fff.util
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 20:38
 */
public class MybatisUtil {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            /*
            保证SqlSessionFactory只有在类加载的时候初始化一次
             */
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(is);

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession对象
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sessionFactory.openSession();
    }

    public static SqlSession getSqlSession(boolean autoCommit) {
        return sessionFactory.openSession(autoCommit);
    }

    public static <T> T getMapper(Class<T> tClass) {
        return sessionFactory.openSession().getMapper(tClass);
    }

    public static <T> T getMapper(Class<T> tClass, boolean autoCommit) {
        return sessionFactory.openSession(autoCommit).getMapper(tClass);
    }


}
