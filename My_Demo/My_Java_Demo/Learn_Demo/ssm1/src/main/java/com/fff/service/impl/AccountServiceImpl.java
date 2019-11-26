package com.fff.service.impl;

import com.fff.dao.IAccountDao;
import com.fff.domain.Account;
import com.fff.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 15:14
 */
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService{


    /**
     * @Title:
     * @MethodName: addUser
     * @Return void
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/1 11:10
     */
    public void addUser() {
        System.out.println(" 业务层 addUser ");
    }

    public void deleteUser() {
        System.out.println(" 业务层 deleteUser ");
    }

    public void updateUser() {
        System.out.println(" 业务层 updateUser ");
    }

    public void queryUser() {
        System.out.println(" 业务层 queryUser ");
    }
}
