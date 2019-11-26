package com.fff.service;

import com.fff.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 15:07
 */
public interface IAccountService {

    void addUser();
    void deleteUser();
    void updateUser();
    void queryUser();

}
