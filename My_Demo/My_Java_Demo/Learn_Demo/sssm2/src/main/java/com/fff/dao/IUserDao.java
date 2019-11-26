package com.fff.dao;

import com.fff.domain.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/3 19:34
 */
public interface IUserDao {

    /**
     * @param userInfo :
     * @Title:
     * @MethodName: insertUserDao
     * @Return java.lang.Integer
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:38
     */
    @Insert("INSERT INTO account(`userName`, `money`) VALUES (#{userName}, #{money})")
    Integer insertUserDao(UserInfo userInfo);

    /**
     * @param aid :
     * @Title:
     * @MethodName: deleteUserByAidDao
     * @Return java.lang.Integer
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:42
     */
    @Delete("DELETE FROM `userInfo` WHERE aid = #{aid}")
    Integer deleteUserByAidDao(Integer aid);

    /**
     * @param userInfo :
     * @Title:
     * @MethodName: updateUserByUserDao
     * @Return java.lang.Integer
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:47
     */
    @Update("UPDATE `userInfo` SET `userName` = #{userName}, `money`= #{money} WHERE `aid` = #{aid}")
    Integer updateUserByUserDao(UserInfo userInfo);

    /**
     * @param aid :
     * @Title:
     * @MethodName: findUserByAidDao
     * @Return com.fff.domain.UserInfo
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:50
     */
    @Select("SELECT `aid`, `userName`, `money` FROM `userInfo` WHERE `aid` = #{aid}")
    UserInfo findUserByAidDao(Integer aid);

    /**
     * @Title:
     * @MethodName: findUserAllDao
     * @Return java.util.List<com.fff.domain.UserInfo>
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:39
     */
    @Select("SELECT `aid`, `userName`, `money` FROM `userInfo`")
    List<UserInfo> findUserAllDao();


}
