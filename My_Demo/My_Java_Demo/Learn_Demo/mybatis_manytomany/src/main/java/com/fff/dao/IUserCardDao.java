package com.fff.dao;

import com.fff.domain.UserCard;
import org.apache.ibatis.annotations.Select;

/**
 * @PackageName：com.fff
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 20:36
 */
public interface IUserCardDao {

    @Select("select * from usercard where userId = #{userId}")
    UserCard findUsercardByUserId(int userId);
}
