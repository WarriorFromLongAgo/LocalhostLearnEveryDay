package com.fff.test;

import com.fff.domain.Account;
import com.fff.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 15:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAccountService {

    @Autowired
    @Qualifier(value = "accountService")
    private IAccountService accountService;

    @Test
    public void findAccountAllDaoTest() {


        List<Account> accountAllService = accountService.findAccountAllService();
        System.out.println(1111);
    }



}
