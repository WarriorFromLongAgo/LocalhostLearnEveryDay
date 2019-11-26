package com.feijm.xiangmu001.dao.impl;


import com.feijm.xiangmu001.dao.IUserDao;
import com.feijm.xiangmu001.domain.UserInfo;
import com.feijm.xiangmu001.util.JDBCUtils;
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
            return userInfo;

        } catch (DataAccessException e) {
            System.out.println("findByUserNameDao");
            return null;
        }
    }

    @Override
    public String findByCodeDao(String code, String status) {
        String sql = "SELECT username FROM tab_user WHERE STATUS = ? AND CODE = ?";
        String userName = null;
        try {
            userName = jdbcTemplate.queryForObject(sql, String.class, status, code);
            return userName;

        } catch (DataAccessException e) {
            System.out.println("findByCodeDao");
            return null;

        }
    }

    @Override
    public boolean activeDao(String status, String userName) {
        String sql = "UPDATE tab_user SET STATUS = ? WHERE username = ?";
        int update = jdbcTemplate.update(sql, status, userName);
        return update > 0;
    }

    @Override
    public boolean registerDao(UserInfo userInfo) {
        String sql = "INSERT INTO tab_user(username, PASSWORD, NAME, birthday, sex, telephone, email, status, code)" +
                "VALUES (?, ?,  ?, ?, ?, ?, ?, ?, ?)";

        int update = jdbcTemplate.update(sql,
                userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getName(),
                userInfo.getBirthday(),
                userInfo.getSex(),
                userInfo.getTelephone(),
                userInfo.getEmail(),
                userInfo.getStatus(),
                userInfo.getCode()
        );

        return update > 0;
    }

    @Override
    public UserInfo loginDao(String userName, String passWord) {
        String sql = "SELECT * FROM tab_user WHERE username = ? AND PASSWORD = ?";

        try {
            List<UserInfo> userInfoList = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class), userName, passWord);
            if (userInfoList.size() == 0) {
                return null;
            }else {
                return userInfoList.get(0);
            }
        } catch (DataAccessException e) {

        }
        return null;
    }

}
