package com.feijm.travel.dao.impl;

import com.feijm.travel.dao.IUserDao;
import com.feijm.travel.domain.UserInfo;
import com.feijm.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public UserInfo findByUserNameDao(String userName) {
        UserInfo userInfo = null;
        try {
            String sql = "SELECT * FROM tab_user WHERE username = ?";
            userInfo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), userName);
        } catch (DataAccessException e) {

        }
        return userInfo;
    }

    @Override
    public boolean registerDao(UserInfo userInfo) {
        String sql = "INSERT INTO tab_user(username, PASSWORD, NAME, birthday, sex, telephone, email)" +
                "VALUES (?, ?,  ?, ?, ?, ?, ?)";

        int update = jdbcTemplate.update(sql,
                userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getName(),
                userInfo.getBirthday(),
                userInfo.getSex(),
                userInfo.getTelephone(),
                userInfo.getEmail()
        );

        return update > 0;
    }
}
