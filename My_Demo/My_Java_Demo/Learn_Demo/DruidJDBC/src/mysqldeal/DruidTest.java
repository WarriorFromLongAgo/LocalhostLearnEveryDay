package mysqldeal;

import org.junit.jupiter.api.Test;

import java.sql.*;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidTest {
    public static void main(String[] args) {
        druidTest();
    }

    @Test
    @SuppressWarnings("all")
    private static void druidTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sqltestone" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        try {
            connection = dataSource.getConnection();
            String sql = "select * from day22homework";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "   " + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement, resultSet);
        }
    }

    public static void closeMysql(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("all")
    public static void closeMysql(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("all")
    public static void closeMysql(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
 * 一，得到Connection
 *   1，准备四大参数
 *   2，加载驱动类
 *   3，得到Connection
 * */
//  jdbc驱动
//  新版本驱动
//        String diver = "com.mysql.cj.jdbc.Driver";
//        //  旧版本驱动
//        //String diver = "com.mysql.jdbc.Driver";
//        //  jdbc的协议格式   jdbc:mysql://
//        //  主机名称:主机端口/数据库名称
//        //  数据库的参数等等，以及时区等信息
//        //  （useUnicode=true：true表示使用unicode编码）
//        //  characterEncoding 当useUnicode设置为true时，指定字符编码。比如可设置为UTF-8、gb2312或gbk false 1.1g
//        //  serverTimezone=GMT%2B8 程序时间东八区
//        //  serverTimezone=UTC  UTC代表的是全球标准时间 ，但是我们使用的时间是北京时区也就是东八区，领先UTC八个小时。
//        //  serverTimezone=Asia/Shanghai 上海时间
//        //  指定是否用ssl连接  1、数据库URL连接地址添加useSSL=false，适用于测试。
//        //                   2、数据库URL连接地址添加useSSL=true，并且提供服务器的验证证书。
//        String url = "jdbc:mysql://localhost:3306/sqltestone" +
//                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8";
//        //  数据库账号
//        String sqlUserName = "root";
//        //  数据库的密码
//        String sqlPassword = "123";
//
//        try {
//            //  加载驱动类
//            Class.forName(diver);
//            System.out.println("加载驱动成功");
//            //  使用DriverManager，和剩下的三个参数，得到connection
//            connection = DriverManager.getConnection(url, sqlUserName, sqlPassword);
//            if (!connection.isClosed()) {
//                System.out.println("数据库连接成功");
//            }
//            //  二，对数据库进行增删改的操作
//            //  1，通过connection创建Statement对象
////            Statement statement = connection.createStatement();
////            //  Statement，sql语句的发送器，向数据库发送sql语句，
////            //  调用
////
//////            String sql = "INSERT INTO student(`name`, id, age) VALUES ('student10', 35, 22)";
//////            String sql = "UPDATE student SET student.`name` = 'student11' WHERE student.id = 11";
////            String sql = "DELETE FROM student WHERE student.id=35";
////            int count = statement.executeUpdate(sql);
////            System.out.println("此条sql语句影响的行数 = " + count);
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("没有安装数据库驱动");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("数据库连接失败");
//        } finally {
//            //  关闭资源
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
