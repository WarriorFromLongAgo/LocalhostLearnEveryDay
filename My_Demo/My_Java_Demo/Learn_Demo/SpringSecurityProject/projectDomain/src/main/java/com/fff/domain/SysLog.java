package com.fff.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/14 16:22
 */
public class SysLog implements Serializable {
    private Integer sysLogId;
    private Date visitTime;
    private String userName;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public SysLog() {
    }



    @Override
    public String toString() {
        return "SysLog{" +
                "sysLogId=" + sysLogId +
                ", visitTime=" + visitTime +
                ", userName='" + userName + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }

    public Integer getSysLogId() {
        return sysLogId;
    }

    public void setSysLogId(Integer sysLogId) {
        this.sysLogId = sysLogId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
