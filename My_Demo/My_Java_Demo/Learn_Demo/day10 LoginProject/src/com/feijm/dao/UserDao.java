package com.feijm.dao;


import com.feijm.model.User;
import com.feijm.util.JdbcDruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UserDao {
    /*检测传入的对象是否存在，数据中存在的话，返回一个user，否则则返回一个null      */
    public User loginDao(User loginUser) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtil.getDataSource());
        try {
            String sql = "SELECT * FROM User WHERE userName = ? AND passWord = ?";
            Map<String, Object> userMap = jdbcTemplate.queryForMap(sql, loginUser.getUserName(), loginUser.getPASSWORD());
            User user = new User();
            BeanUtils.populate(user, userMap);
            return user;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (EmptyResultDataAccessException e) {
            System.out.println("未找到数据");
        }

        return null;
    }
}
