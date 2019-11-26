package com.fff.test;

import com.fff.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 21:40
 */
public class TestAccount {


    @Test
    public void testAccount() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.insertAccountService();
        accountService.deleteAccount();
        accountService.updateAccountService(1);


    }
}
