package com.feijm.travel.domain;

import java.io.Serializable;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    //旅游线路对象
    private TouristRoute touristRoute;
    //收藏时间
    private String date;
    //所属用户
    private UserInfo userInfo;

    /**
     * 无参构造方法
     */
    public Favorite() {
    }

    /**
     * 有参构造方法
     * @param touristRoute
     * @param date
     * @param userInfo
     */
    public Favorite(TouristRoute touristRoute, String date, UserInfo userInfo) {
            this.touristRoute = touristRoute;
            this.date = date;
            this.userInfo = userInfo;
    }

    public TouristRoute getTouristRoute() {
        return touristRoute;
    }

    public void setTouristRoute(TouristRoute touristRoute) {
        this.touristRoute = this.touristRoute;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
