package com.fff.dao.impl;

import com.fff.dao.IUserDao;
import com.fff.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SuppressWarnings("action")
public class UserDaoImpl implements IUserDao {

    public List<User> findAllDao() {
//        Resources
        try {
//            加载主配置文件，获得数据库连接数据，
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<User> userList = sqlSession.selectList("com.fff.dao.IUserDao.findAllDao");

            sqlSession.close();
            inputStream.close();

            return userList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insertUserDao(User user) {
        try {
//            加载主配置文件，获得数据库连接数据，
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(user);
            int insert = sqlSession.insert("com.fff.dao.IUserDao.insertUserDao", user);
            System.out.println(user);
            System.out.println(insert > 0);

            sqlSession.commit();

            sqlSession.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        try {
//            加载主配置文件，获得数据库连接数据，
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            int delete = sqlSession.delete("com.fff.dao.IUserDao.deleteById", id);

            System.out.println(delete > 0);

            sqlSession.commit();

            sqlSession.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteByIdAndUserName(User user) {
        try {
//            加载主配置文件，获得数据库连接数据，
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

//            int delete = sqlSession.delete("com.fff.dao.IUserDao.deleteByIdAndUserName", id, userName);

            IUserDao userDao = sqlSession.getMapper(IUserDao.class);
            userDao.deleteByIdAndUserName(user);


            sqlSession.commit();

            sqlSession.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> findUserByName(String userName) {

        try {
//            加载主配置文件，获得数据库连接数据，
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            List<User> userList = sqlSession.selectList("com.fff.dao.IUserDao.findUserByName", userName);

            sqlSession.close();
            inputStream.close();

            return userList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void updateUserById(User user) {

    }
}
