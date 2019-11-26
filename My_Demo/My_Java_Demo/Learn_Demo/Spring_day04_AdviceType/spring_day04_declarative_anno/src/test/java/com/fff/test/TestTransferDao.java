package com.fff.test;

import com.fff.domain.Transfer;
import com.fff.service.ITransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/22 20:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestTransferDao {

    @Autowired
    @Qualifier(value = "transferService")
    private ITransferService transferService;

    @Test
    public void findTransferByUseridDaoTest() {
        Transfer transfer = transferService.findTransferByUseridService(1);
        System.out.println(transfer);
    }

    @Test
    public void transferMoneyServiceTest() {
        int i = transferService.transferMoneyService("111", "222", 100);

        System.out.println(i >= 2);


    }

}
