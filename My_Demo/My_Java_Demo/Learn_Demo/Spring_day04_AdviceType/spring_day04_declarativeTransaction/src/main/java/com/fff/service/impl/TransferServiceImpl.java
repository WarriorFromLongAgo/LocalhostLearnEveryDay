package com.fff.service.impl;

import com.fff.dao.ITransferDao;
import com.fff.domain.Transfer;
import com.fff.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/22 19:34
 */
@Service(value = "transferService")
public class TransferServiceImpl implements ITransferService {

    @Autowired
    @Qualifier(value = "transferDao")
    private ITransferDao transferDao;


    public Transfer findTransferByUseridService(int userId) {


        return transferDao.findTransferByUseridDao(userId);
    }

    public int transferMoneyService(String outUserName, String inUserName, double money) {
        System.out.println("transferMoneyService");

        Transfer outUser = transferDao.findTransferByUsernameDao(outUserName);
        Transfer inUser = transferDao.findTransferByUsernameDao(inUserName);

        outUser.setMoney(outUser.getMoney() - money);
        inUser.setMoney(inUser.getMoney() + money);
        int i21121 = 1 / 0;
        int i = transferDao.updateTransfeByUserIdrDao(outUser);
        int i1 = transferDao.updateTransfeByUserIdrDao(inUser);

        return (i + i1);

    }
}
