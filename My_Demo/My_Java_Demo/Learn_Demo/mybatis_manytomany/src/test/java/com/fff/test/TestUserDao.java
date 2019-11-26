package com.fff.test;

import com.fff.dao.IUserCardDao;
import com.fff.dao.IUserDao;
import com.fff.domain.UserCard;
import com.fff.domain.UserInfo;
import com.fff.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 20:40
 */
public class TestUserDao {

    @Test
    public void findUserAllDaoTest() {
        IUserDao userDao = MybatisUtil.getMapper(IUserDao.class);
        List<UserInfo> userInfoList = userDao.findUserAllDao();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void findUsercardByUserIdTest() {
        IUserCardDao userCardDao = MybatisUtil.getMapper(IUserCardDao.class);
        UserCard usercard = userCardDao.findUsercardByUserId(1);
        System.out.println(usercard);
    }

}
