package com.fff.service;

import com.fff.domain.Transfer;
import org.springframework.stereotype.Service;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/22 19:28
 */
public interface ITransferService {

    Transfer findTransferByUseridService(int userId);

    int transferMoneyService(String outUserName, String inUserName, double money);
}
