package com.feijm.dao;

import com.feijm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserInfoDao {

    @Select("select * from mybatisdemo")
    List<UserInfo> findAllDao();
}
