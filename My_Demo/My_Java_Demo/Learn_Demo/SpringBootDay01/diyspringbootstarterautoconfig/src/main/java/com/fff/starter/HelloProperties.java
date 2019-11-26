package com.fff.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @PackageName：com.fff.starter
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/18 21:27
 */
@ConfigurationProperties(prefix = "application.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
