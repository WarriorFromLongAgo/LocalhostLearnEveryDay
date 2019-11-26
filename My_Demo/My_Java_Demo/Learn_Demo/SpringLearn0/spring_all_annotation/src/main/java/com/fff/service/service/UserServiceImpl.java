package com.fff.service.service;

import com.fff.dao.IUserDao;
import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
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


    public List<UserInfo> findUserAllService() {

        return userDao.findUserAllDao();
    }


    @PostConstruct   //指定对象创建之后执行的初始化方法
    public void initMethod(){
        System.out.println("initMethod。。。。。");
    }

    @PreDestroy //指定对象销毁之前执行的方法
    public void destoryMethod(){
        System.out.println("destoryMethod。。。。。");
    }
}
