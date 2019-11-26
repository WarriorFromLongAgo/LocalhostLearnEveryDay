package com.feijm.dao;

import com.feijm.domain.People;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPeopleDao {

    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：
     * @more info   ：
     * @more info   ：
     */
    @Select("select * from mybatisdemo")
    public abstract List<People> findAllDao();


}
