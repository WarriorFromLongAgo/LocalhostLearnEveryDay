package com.fff.dao;

import com.fff.domain.Permission;
import com.fff.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/12 21:48
 */
public interface IPermissionDao {

    @Select("SELECT permissionId, permissionName, url FROM permission WHERE roleId = #{roleId}")
    Permission findPermissionByIdDao(Integer roleId);

}
