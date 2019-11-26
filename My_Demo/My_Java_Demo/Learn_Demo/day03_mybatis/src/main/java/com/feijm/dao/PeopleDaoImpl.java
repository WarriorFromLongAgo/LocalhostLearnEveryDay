package com.feijm.dao;

import com.feijm.domain.People;

import java.util.List;

public class PeopleDaoImpl implements IPeopleDao {

    private SqlSessionFactory sqlSessionFactory;

    public PeopleDaoImpl(SqlSessionFactory iutPutSqlSessionFactory) {
        sqlSessionFactory = iutPutSqlSessionFactory;
    }

    public List<People> findAllDao() {
//        3，使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        使用session执行查询所有方法
        List<People> peopleList = sqlSession.selectList("com.feijm.dao.IPeopleDao.findAllDao");

        return peopleList;
    }
}
