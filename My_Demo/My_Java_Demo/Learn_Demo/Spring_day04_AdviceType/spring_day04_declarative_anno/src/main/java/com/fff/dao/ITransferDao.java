package com.fff.dao;

import com.fff.domain.Transfer;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/22 19:27
 */
public interface ITransferDao {
    Transfer findTransferByUseridDao(int userId);

    Transfer findTransferByUsernameDao(String userName);

    int updateTransfeByUserIdrDao(Transfer transfer);

}
