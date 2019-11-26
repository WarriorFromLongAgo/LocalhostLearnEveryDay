package com.fff.mybatis2;

import com.fff.dao.impl.UserDaoImpl;
import com.fff.domain.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class IUserDaoTest {
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

    @Test
    public void findUserByNameTest() {
        UserDaoImpl userDao = new UserDaoImpl();
//        List<User> userByName = userDao.findUserByName("%i%");
        List<User> userByName = userDao.findUserByName("i");
        System.out.println(userByName);
    }

    @Test
    public void updateUserByUserTest() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setId(40);

        user.setUsername("凯爷");
        user.setBirthday(new Date());
        user.setAddress("湖南邵阳");
        user.setSex("男");

        userDao.updateUserByUser(user);

    }
}
