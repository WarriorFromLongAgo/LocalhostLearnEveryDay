package com.fff.service.impl;

import com.fff.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 18:42
 */
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {
    public void insertAccountService() {
        System.out.println("执行了保存");
    }

    public void updateAccountService(int i) {
        System.out.println("执行了修改");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");

        return 0;
    }
}
