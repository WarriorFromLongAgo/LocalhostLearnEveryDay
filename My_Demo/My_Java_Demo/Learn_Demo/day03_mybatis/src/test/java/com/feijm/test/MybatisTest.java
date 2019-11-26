package com.feijm.test;

import com.feijm.dao.IPeopleDao;
import com.feijm.dao.PeopleDaoImpl;
import com.feijm.domain.People;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
//       入门案例
//        1，读取配置文件
//        为了加载SqlMapConfig.xml里面的信息
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        ClassLoader classLoader = MybatisTest.class.getClassLoader();
//        InputStream inputStream = Resources.getResourceAsStream(classLoader, "SqlMapConfig.xml");

//        2，创建SqlSessionFactory工厂，接口
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//        3，使用dao创建对象
        IPeopleDao peopleDao = new PeopleDaoImpl(sqlSessionFactory);

////        4，使用SqlSession创建Dao接口的代理对象
//        IPeopleDao peopleDao = sqlSession.getMapper(IPeopleDao.class);

//        4，使用代理对象来执行方法
        List<People> peopleList = peopleDao.findAllDao();
        for (People people : peopleList) {
            System.out.println(people);
        }

//        6，释放资源
//        sqlSession.close();
        inputStream.close();
    }
}
