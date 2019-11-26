package com.myserver.mysqldeal;

import com.myserver.studentbeans.StudentBeans;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MysqlDeal implements MysqlBean {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/sqltestone" +
            "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8" +
            "&useServerPrepStmts=true&cachePrepStmts=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123";

    /**
     * @Author: feijm
     * @Time: 2019年8月13日20:58:36
     * @version: 1.0.0
     * @修改原因:
     * @作用 查询数据库 mysqlColum列 是否存在和传入的compareData相同的元素，
     * 相同则返回true，应要求用户再次输入
     * 不同则返回false，可以正常的插入数据
     */
    @Override
    public boolean selectAnyColum(String mysqlColum, String compareData) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println(" selectAnyColum 连接成功 ");

                String sql = "SELECT studentUserName FROM day28student";
                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, "studentUserName");

                resultSet = preparedStatement.executeQuery();
                int resultSetRowLength = resultSet.getMetaData().getColumnCount();
//                System.out.println(resultSetRowLength);
//                System.out.println(compareData);
                while (resultSet.next()) {
//                    System.out.println(mysqlColum);
//                    System.out.println("studentUserName = " + resultSet.getString("studentUserName"));
//                    System.out.println("compareData = " + compareData);
//                    for (int i = 1; i <= resultSetRowLength; i++) {
                    if (compareData.equals(resultSet.getString("studentUserName"))) {
                        flag = true;
                        return flag;
                    }
//                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement, resultSet);
        }
        return flag;
    }

    /**
     * @Author:
     * @Project:
     * @Time:
     * @version:
     * @修改原因:
     */
    @Override
    public Map<String, StudentBeans> selectOneRow(String studentUserName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println(" selectOneRow 连接成功 ");

                String sql = "SELECT * FROM day28student where studentUserName = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, studentUserName);
                resultSet = preparedStatement.executeQuery();
//                int resultSetRowLength = resultSet.getMetaData().getColumnCount();
                Map<String, StudentBeans> strStudentBeansMap = new HashMap<>();

                while (resultSet.next()) {
                    String tempStudentUUID = resultSet.getString("studentUUID");
                    String tempstudentUserName = resultSet.getString("studentUserName");
                    String tempStudentName = resultSet.getString("studentName");
                    Integer tempStudentAge = resultSet.getInt("studentAge");
                    String tempStudentClassName = resultSet.getString("studentClassName");
                    StudentBeans tempStudentBeans = new StudentBeans(tempStudentUUID, tempstudentUserName, tempStudentName, tempStudentAge, tempStudentClassName);
                    strStudentBeansMap.put(tempstudentUserName, tempStudentBeans);
                }
                return strStudentBeansMap;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public Map<String, StudentBeans> displayAllData() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println(" displayAllData 连接成功 ");

                String sql = "SELECT * FROM day28student";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                Map<String, StudentBeans> strStudentBeansMap = new HashMap<>();

                while (resultSet.next()) {
//                    String tempStudentUUID = resultSet.getString("studentUUID");
                    String tempstudentUserName = resultSet.getString("studentUserName");
                    String tempStudentName = resultSet.getString("studentName");
                    Integer tempStudentAge = resultSet.getInt("studentAge");
                    String tempStudentClassName = resultSet.getString("studentClassName");
                    StudentBeans tempStudentBeans = new StudentBeans(tempstudentUserName, tempStudentName, tempStudentAge, tempStudentClassName);
                    strStudentBeansMap.put(tempstudentUserName, tempStudentBeans);
                }
                return strStudentBeansMap;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement, resultSet);
        }
        return null;


    }

    /**
     * @Author: feijm
     * @Time: 2019年8月13日21:00:48
     * @version:
     * @修改原因:
     * @作用 增加数据，五个元素
     */
    @Override
    public boolean insertMysql(StudentBeans studentBeans) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println(" insertMysql 连接成功 ");
                System.out.println(studentBeans.getStudentUUID());
                String sql = "INSERT INTO day28student(studentUUID, studentUserName, studentName, studentAge, studentClassName)" +
                        " values (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, studentBeans.getStudentUUID());
                preparedStatement.setString(2, studentBeans.getStudentUserName());
                preparedStatement.setString(3, studentBeans.getStudentName());
                preparedStatement.setInt(4, studentBeans.getStudentAge());
                preparedStatement.setString(5, studentBeans.getStudentClassName());
                int count = preparedStatement.executeUpdate();
                return flag = (count > 0);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement);
        }
        return flag;
    }

    /**
     * @Author: feijm
     * @Time: 2019年8月13日21:00:48
     * @version:
     * @修改原因:
     * @作用 删除一行元素   studentUserName的一行
     */
    @Override
    public boolean deleteMysql(String studentUserName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println(" deleteMysql 连接成功 ");

                String sql = "DELETE FROM day28student where studentUserName = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, studentUserName);

                int count = preparedStatement.executeUpdate();
                return flag = (count > 0);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement);
        }
        return flag;
    }

    /**
     * @Author: feijm
     * @Time: 2019年8月13日21:00:48
     * @version:
     * @修改原因:
     * @作用 根据用户账号 修改用户的其他信息
     */
    @Override
    public boolean updataMysql(StudentBeans studentBeans) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println(" updataMysql 连接成功 ");

                String sql = "UPDATE day28student SET studentName = ?" +
                        ", studentAge = ?, studentClassName = ? WHERE studentUserName = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, studentBeans.getStudentName());
                preparedStatement.setInt(2, studentBeans.getStudentAge());
                preparedStatement.setString(3, studentBeans.getStudentClassName());
                preparedStatement.setString(4, studentBeans.getStudentUserName());
                int count = preparedStatement.executeUpdate();
                return flag = (count > 0);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeMysql(connection, preparedStatement);
        }
        return flag;
    }

    @Override
    public void testMysql() {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sqltestone" +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8";
        String sqlUserName = "root";
        String sqlPassWord = "123";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, sqlUserName, sqlPassWord);
            if (connection != null) {
                System.out.println(" 数据库连接成功 ");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            closeMysql(connection);

        }
    }

    @Override
    public void closeMysql(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeMysql(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeMysql(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

