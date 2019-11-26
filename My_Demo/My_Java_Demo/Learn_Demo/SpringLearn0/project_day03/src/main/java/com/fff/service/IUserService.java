package com.fff.service;

import com.fff.domain.UserInfo;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：service 接口
 * @Description：
 * @author：
 * @date：2019/10/20 12:40
 */
public interface IUserService {
    List<UserInfo> findUserAllService();


    /**
     * @Author 
     * @Description 转账，
     * @Date 2019/10/21 11:04 
     * @Param   sourceName转入账户名称，targetName转出账户名称，money 转账金额
     * @return
     **/
     
    void transfer(String sourceName, String targetName, Float money);
}
