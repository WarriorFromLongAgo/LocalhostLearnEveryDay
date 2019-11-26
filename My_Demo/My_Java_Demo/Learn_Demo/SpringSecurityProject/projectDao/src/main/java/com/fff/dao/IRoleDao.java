package com.fff.dao;

import com.fff.domain.Permission;
import com.fff.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 22:41
 */
public interface IRoleDao {

    @Select("SELECT * FROM role WHERE roleId IN (SELECT roleId FROM userInfo_role WHERE userInfoId = #{userInfoId})")
    List<Role> findAllRoleByIdDao(Integer userInfoId);

    @Select("SELECT * FROM role WHERE roleId IN (SELECT roleId FROM userInfo_role WHERE userInfoId = #{userInfoId})")
    @Results({
            @Result(id = true, column = "roleId", property = "roleId"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(property = "permission", javaType = Permission.class,
                    column = "roleId",
                    one = @One(select = "com.fff.dao.IPermissionDao.findPermissionByIdDao")
            )
    })
    List<Role> findAllRoleByIdAndPermissionDao(Integer userInfoId);

    @Select("SELECT * FROM role")
    List<Role> findAllRoleDao();
}
