package com.fff;

import com.fff.dao.impl.UserDaoImpl;
import com.fff.domain.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserDaoImplTest {

    @Test
    public void findAllDaoTest() {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.findAllDao();

        System.out.println(userList);
    }

    @Test
    public void insertUserDaoTest() {

        User user = new User(41, "ice", new Date(), "男", "湖北湖南");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUserDao(user);

    }

    @Test
    public void deleteByIdDaoTest() {

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.deleteById(54);

    }

    @Test
    public void deleteByIdAndUserNameTest() {
        User user = new User("ice", new Date(), "男", "湖北湖南");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.deleteByIdAndUserName(user);
    }

}
