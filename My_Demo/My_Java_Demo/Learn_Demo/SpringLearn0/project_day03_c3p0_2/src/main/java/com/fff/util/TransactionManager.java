package com.fff.util;

import java.sql.SQLException;

/**
 * @PackageName：com.fff.util
 * @ClassName：
 * @Description：和事务相关的工具类，开启事务，提交事务，回滚事务，释放连接
 * @author：
 * @date：2019/10/21 11:42
 */
public class TransactionManager {

    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    /**
     * @Author 
     * @Description 
     * @Date 2019/10/21 11:52 
     * @Param 开启事务
     * @return 
     **/
    public void beginTransaction() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @Author 
     * @Description 
     * @Date 2019/10/21 11:52 
     * @Param 提交事务
     * @return 
     **/
    public void commitTransaction() {
        try {
            connectionUtil.getThreadConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @Author 
     * @Description 
     * @Date 2019/10/21 11:53 
     * @Param 事务回滚
     * @return
     **/
    public void rollbackTransaction() {
        try {
            connectionUtil.getThreadConnection().rollback();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @Author 
     * @Description 
     * @Date 2019/10/21 11:53 
     * @Param 释放连接
     * @return
     **/
    public void releaseTransaction() {
        try {
            connectionUtil.getThreadConnection().close();
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
