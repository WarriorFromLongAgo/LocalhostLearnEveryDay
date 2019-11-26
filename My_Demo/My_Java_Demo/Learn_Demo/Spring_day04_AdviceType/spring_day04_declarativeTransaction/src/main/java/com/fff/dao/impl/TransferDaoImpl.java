package com.fff.dao.impl;

import com.fff.dao.ITransferDao;
import com.fff.domain.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @PackageName：com.fff.dao.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/22 19:42
 */
@Repository(value = "transferDao")
public class TransferDaoImpl implements ITransferDao {

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public Transfer findTransferByUseridDao(int userId) {
        String sql = "select * from transfer where userId = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Transfer>(Transfer.class), userId);
    }

    public Transfer findTransferByUsernameDao(String userName) {
        String sql = "select * from transfer where userName = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Transfer>(Transfer.class), userName);
    }

    public int updateTransfeByUserIdrDao(Transfer transfer) {
        String sql = "UPDATE transfer SET money = ?, userName = ? WHERE userId = ?";

        return jdbcTemplate.update(sql, transfer.getMoney(), transfer.getUserName(), transfer.getUserId());
    }

}
