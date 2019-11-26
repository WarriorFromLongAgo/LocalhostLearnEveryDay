package com.fff.springboot_redis.mapper;

import com.fff.springboot_redis.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @PackageName：com.fff.mapper
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/15 15:06
 */
@Mapper
public interface UserMapper {


    @Select("select * from userInfo")
    List<UserInfo> findAllUserInfoAnnoMapper();

    @Select("select * from userInfo where userInfoId = #{userInfoId}")
    UserInfo findUserByIdAnnoMapper(Integer userInfoId);

    @Options(useGeneratedKeys = true, keyProperty = "userInfoId")
    @Insert("INSERT INTO userInfo(`userName`, `passWord`) VALUES (#{userName}, #{passWord})")
    Integer insertUserByUserAnnoMapper(UserInfo userInfo);

    @Update("UPDATE userInfo SET `userName` = #{userName}, `passWord` = #{passWord} " +
            "WHERE userInfoId = #{userInfoId}")
    Integer updateUserByUserAnnoMapper(UserInfo userInfo);

    @Delete("DELETE FROM userInfo WHERE userInfoId = #{userInfoId}")
    Integer deleteUserByIdAnnoMapper(Integer userInfoId);


//    @Options(useGeneratedKeys = true, keyProperty = "userInfoId")
//    @Insert("insert into userinfo values #{}")
//    public Integer insertUserInfoMapper(UserInfo userInfo);



}
