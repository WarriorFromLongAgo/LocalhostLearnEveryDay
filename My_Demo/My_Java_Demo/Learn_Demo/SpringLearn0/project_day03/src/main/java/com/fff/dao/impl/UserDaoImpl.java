package com.fff.dao.impl;

import com.fff.dao.IUserDao;
import com.fff.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PackageName：com.fff.dao.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 15:17
 */
@Repository(value = "userDao")
@Scope("prototype")
public class UserDaoImpl implements IUserDao {

//    @Resource JDK提供
//    可以完成依赖注入，根据名字查找指定id的对象注入给这个属性
//    他是和jdk版本相关的，jdk1.8之前可以使用，以后就不可以使用了。

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @return
     * @Author
     * @Description
     * @Date 2019/10/20 19:54
     * @Param 从数据查找数据
     **/
    public List<UserInfo> findUserAllDao() {
        String sql = "SELECT * FROM userinfo";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
    }

    public UserInfo findUserInfoByName(String userName) {
        String sql = "SELECT * FROM userinfo WHERE `userName` = ?";

        List<UserInfo> userInfoList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<UserInfo>(UserInfo.class), userName);
        if (userInfoList == null || userInfoList.size() == 0) {
            return null;
        } else if (userInfoList.size() > 1) {
           throw new RuntimeException("结果集不为1，数据有问题");
        } else {
            return userInfoList.get(0);
        }

    }
}
