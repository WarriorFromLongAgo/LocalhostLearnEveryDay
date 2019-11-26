package com.fff.mapper;

import com.fff.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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

    /**
     * @Title:
     * @MethodName: findAllUserInfoMapper
     * @Return java.util.List<com.fff.domain.UserInfo>
     * @Description:    查找userinfo表，获得所有的userinfo对象
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/15 15:07
     */
    List<UserInfo> findAllUserInfoMapper();

    @Select("select * from userinfo")
    List<UserInfo> findAllUserInfoAnnoMapper();

    @Options(useGeneratedKeys = true, keyProperty = "userInfoId")
    @Insert("insert into userinfo values #{}")
    public Integer insertUserInfoMapper(UserInfo userInfo);
}
