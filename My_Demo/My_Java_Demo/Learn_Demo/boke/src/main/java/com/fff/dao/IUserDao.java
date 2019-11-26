package com.fff.dao;

import com.fff.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAllDao();

    void insertUserDao(User user);

    void deleteById(Integer id);

    void deleteByIdAndUserName(User user);

    List<User> findUserByName(String userName);

    void updateUserById(User user);
}
