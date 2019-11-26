package com.fff.springbootjdbc2.springbootjdbc2.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName：com.fff.springbootjdbc2.springbootjdbc2.config
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/17 22:13
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid 的监控
     * 配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletServletRegistrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String, String> initParams = new HashMap<>();
//        允许登录
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "localhost");
//        不写，默认允许所有人登录
//        initPara.put("allow","");

//        拒绝访问
        initParams.put("deny", "192.168.80.222");

        servletServletRegistrationBean.setInitParameters(initParams);

        return servletServletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>();

        filterFilterRegistrationBean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js, *.css, /druid/*");

        filterFilterRegistrationBean.setInitParameters(initParams);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return filterFilterRegistrationBean;
    }


}
