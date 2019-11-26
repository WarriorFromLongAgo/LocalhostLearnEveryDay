package com.feijm.mmybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：自定义mybatis的配置类。
 * @more info   ：
 * @more info   ：
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper>  mappers) {
//        this.mappers = mappers;
//        传入的mappers是添加在后面
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
