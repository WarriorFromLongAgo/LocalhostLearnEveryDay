package com.fff.service.service;

import com.fff.dao.IUserDao;
import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import com.fff.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @PackageName：com.fff.service.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 15:18
 */
@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements IUserService {

//    @Resource(name = "userDao")   @Resource   JDK提供
//    可以完成依赖注入，根据名字查找指定id的对象注入给这个属性
//    他是和jdk版本相关的，jdk1.8之前可以使用，以后就不可以使用了。

    @Autowired
    @Qualifier("userDao")
    private IUserDao userDao;

    @Autowired
    @Qualifier("transactionManager")
    private TransactionManager transactionManager;


    public List<UserInfo> findUserAllService() {
        try {
//        1，开启事务
            transactionManager.beginTransaction();
//        2，执行操作
            List<UserInfo> userInfoList = userDao.findUserAllDao();
//        3，提交事务
            transactionManager.submitTransaction();
//        4，返回结果
            return userInfoList;
        } catch (Exception e) {
//        5，回滚操作
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
//        6，释放连接
            transactionManager.releaseTransaction();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {

//        必须引入事务的处理


//        1，根据名称查询转出账户
//        2，根据形成查询转入账户
//        3，转出账户减钱
//        4，转入账户加钱
//        5，更新转出账户
//        6，更新转入账户

    }


    @PostConstruct   //指定对象创建之后执行的初始化方法
    public void initMethod() {
        System.out.println("initMethod。。。。。");
    }

    @PreDestroy //指定对象销毁之前执行的方法
    public void destoryMethod() {
        System.out.println("destoryMethod。。。。。");
    }
}
