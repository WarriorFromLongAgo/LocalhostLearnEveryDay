package com.myserver.mysqldeal;

import com.myserver.studentbeans.StudentBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public interface MysqlBean {
    /**
     * @Author:feijm
     * @Project: 查询数据库中的第mysqlColum列中，是否存在compareData传入的这个元素
     * 有的话返回true，认为不允许再次插入相同的元素
     * 没有的话返回false，认为可以插入该元素
     * <p>
     * 主要是查询查询student的账号
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract boolean selectAnyColum(String mysqlColum, String compareData);

    /**
     * @Author:feijm
     * @Project: 显示所有的学生
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract Map<String, StudentBeans> displayAllData();

    /**
     * @Author:feijm
     * @Project: 返回数据库的一行元素，根据学生的账号
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract Map<String, StudentBeans> selectOneRow(String studentUserName);

    /**
     * @Author:feijm
     * @Project: 插入一个student对象
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract boolean insertMysql(StudentBeans studentBeans);

    /**
     * @Author:feijm
     * @Project:删除一个student对象，传入的是学生的账号
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract boolean deleteMysql(String studentUserName);

    /**
     * @Author:feijm
     * @Project:修改学生的信息，在此之前必须调用方法，查看student的账号
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract boolean updataMysql(StudentBeans studentBeans);

    /**
     * @Author:
     * @Project:测试数据库是否连接正常
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract void testMysql();

    /**
     * @Author:
     * @Project:数据库的关闭
     * @Time:
     * @version:
     * @修改原因:
     */
    public abstract void closeMysql(Connection connection);

    public abstract void closeMysql(Connection connection, PreparedStatement preparedStatement);

    public abstract void closeMysql(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet);
}
