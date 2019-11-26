package com.fff.dao;

import com.fff.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 15:06
 */
@Repository
public interface IAccountDao {

    /**
     * @param :
     * @Title:
     * @MethodName: findAccountAllDao
     * @Return
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/10/27 15:09
     */
    @Select("SELECT * FROM ACCOUNT")
    List<Account> findAccountAllDao();

    /**
     * @param :
     * @Title:
     * @MethodName:
     * @Return
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/10/27 15:11
     */
    @Insert("INSERT INTO account(`userName`, `money`) VALUES (#{userName}, #{money})")
    Integer insertAccountDao(Account account);

}
