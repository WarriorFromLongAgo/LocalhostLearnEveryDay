package com.fff.test;

import com.fff.dao.IAccountDao;
import com.fff.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 17:26
 */
public class TestMybatis {
    @Test
    public void mybatisTest() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IAccountDao IAccountDao = sqlSession.getMapper(IAccountDao.class);

//            Account account = new Account("ff", 22.0);
//            Integer integer = accountDao.insertAccountDao(account);
//            sqlSession.commit();
//            System.out.println(integer);

            List<Account> accountList = IAccountDao.findAccountAllDao();
            for (Account account : accountList) {
                System.out.println(account);
            }

            sqlSession.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
