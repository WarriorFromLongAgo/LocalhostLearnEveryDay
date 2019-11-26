package com.fff.dao;

import com.fff.domain.UserCard;
import com.fff.domain.UserInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 20:36
 */
public interface IUserDao {

    @Select("select * from userinfo")
    @Results(
            value = {
                    @Result(id = true, column = "userId", property = "userId"),
                    @Result(column = "userName", property = "userName"),
                    @Result(column = "passWord", property = "passWord"),
                    @Result(
                            property = "userCard", javaType = UserCard.class,
                            column = "userId",
                            one = @One(select = "com.fff.dao.IUserCardDao.findUsercardByUserId")
                    )
            }
    )
    List<UserInfo> findUserAllDao();
}
