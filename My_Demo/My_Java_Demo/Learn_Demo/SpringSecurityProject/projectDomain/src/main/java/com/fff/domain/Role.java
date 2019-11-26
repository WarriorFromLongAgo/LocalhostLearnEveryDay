package com.fff.domain;

import java.util.List;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 20:49
 */
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private Permission permission;
//    private List<User> users;


    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleDesc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public Role(Integer roleId, String roleName, String roleDesc, Permission permission) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permission=" + permission +
                '}';
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
