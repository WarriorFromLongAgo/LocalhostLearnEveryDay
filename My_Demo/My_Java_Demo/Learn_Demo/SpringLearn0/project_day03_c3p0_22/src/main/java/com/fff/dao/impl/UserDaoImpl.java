package com.fff.dao.impl;

import com.fff.dao.IUserDao;
import com.fff.domain.UserInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @PackageName：com.fff.dao.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 15:17
 */
public class UserDaoImpl implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserInfo> findUserAllDao() {
        String sql = "SELECT * FROM userinfo";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
    }

    public int updateUserByUserDao(UserInfo userInfo) {
        String sql = "UPDATE userinfo SET `passWord` = ? WHERE `userId` = ?";

        return jdbcTemplate.update(sql, userInfo.getPassWord(), userInfo.getUserId());
    }

    public int insertUserDao(UserInfo userInfo) {
        String sql = "INSERT INTO userinfo VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql, userInfo.getUserId(), userInfo.getUserName(), userInfo.getPassWord());
    }

    public int deleteUserByIdDao(int userId) {
        String sql = "DELETE FROM userinfo WHERE userId = ?";

        return jdbcTemplate.update(sql, userId);
    }
}
