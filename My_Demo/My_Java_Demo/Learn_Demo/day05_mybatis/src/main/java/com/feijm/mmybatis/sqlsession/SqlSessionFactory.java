package com.feijm.mmybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：用于打开一个新的sqlSession对象
     * @more info   ：
     * @more info   ：
     */
    public abstract SqlSession openSession();
}
