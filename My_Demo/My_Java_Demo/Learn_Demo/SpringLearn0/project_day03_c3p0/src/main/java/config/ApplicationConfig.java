package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @PackageName：config
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 21:50
 */
@Configuration
@ComponentScan(value = {"com.fff.dao", "com.fff.service"})
@Import(value = DataSourceConfig.class)
@PropertySource(value = "jdbc.properties")
public class ApplicationConfig {

}
