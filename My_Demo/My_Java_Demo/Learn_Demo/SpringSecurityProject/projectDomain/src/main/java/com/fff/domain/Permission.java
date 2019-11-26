package com.fff.domain;

import java.util.List;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 20:48
 */
public class Permission {
    private Integer permissionId;
    private String permissionName;
    private String url;
//    private List<Role> roleList;

    public Permission() {
    }

    public Permission(Integer permissionId, String permissionName, String url) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
//                ", roleList=" + roleList +
                '}';
    }

//    public List<Role> getRoleList() {
//        return roleList;
//    }

//    public void setRoleList(List<Role> roleList) {
//        this.roleList = roleList;
//    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
