package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @PackageName：config
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 21:57
 */
@Configuration
public class DataSourceConfig {
//        <property name="driverClassName"value="${jdbc.mysql.driver}"></property>
//        <property name="url"value="${jdbc.url}"></property>
//        <property name="username"value="${jdbc.username}"></property>
//        <property name="password"value="${jdbc.password}"></property>

    @Value("${jdbc.mysql.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//    @Bean("dataSource")
//    @Scope("singleton")
//    public DataSource getDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//
//        return dataSource;
//    }

    @Bean("dataSource")
    @Scope("singleton")
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();

            dataSource.setDriverClass(driverClassName);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
