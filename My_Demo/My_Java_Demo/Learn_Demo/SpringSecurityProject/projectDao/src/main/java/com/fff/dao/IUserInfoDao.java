package com.fff.dao;

import com.fff.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 21:16
 */
public interface IUserInfoDao {

    @Select("SELECT * FROM userInfo WHERE userName = #{userName}")
    @Results({
            @Result(id = true, column = "userInfoId", property = "userInfoId"),
            @Result(column = "email", property = "email"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "passWord", property = "passWord"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roleList", javaType = java.util.List.class,
                    column = "userInfoId",
                    many = @Many(select = "com.fff.dao.IRoleDao.findAllRoleByIdDao")
            )
    })
    UserInfo findUserInfoByUserNameDao(String userName);


    @Select("SELECT * FROM userInfo WHERE userInfoId = #{userInfoId}")
    @Results({
            @Result(id = true, column = "userInfoId", property = "userInfoId"),
            @Result(column = "email", property = "email"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "passWord", property = "passWord"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roleList", javaType = java.util.List.class,
                    column = "userInfoId",
                    many = @Many(select = "com.fff.dao.IRoleDao.findAllRoleByIdAndPermissionDao")
            )
    })
    UserInfo findUserInfoByIdDao(Integer userInfoId);

    @Select("SELECT * FROM userInfo")
    List<UserInfo> findAllUserDao();


    @Insert("INSERT INTO userinfo VALUES(NULL, #{email}, #{userName}, #{passWord}, #{phoneNum}, #{status})")
    Integer insertUserDao(UserInfo userInfo);
}
