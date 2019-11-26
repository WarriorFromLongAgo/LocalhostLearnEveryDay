package mysqldeal;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class readPropperties {
    @Test
    public void demo2() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\MyJAVADemo\\DruidJDBC\\src\\druid.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            // 获得连接:
            connection = dataSource.getConnection();
            // 编写SQL：
            String sql = "select * from day22homework";
            preparedStatement = connection.prepareStatement(sql);
            // 执行sql:
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "   " +
                        resultSet.getString("name") + "   " +
                        resultSet.getDouble("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidTest.closeMysql(connection, preparedStatement, resultSet);
        }
    }
}
