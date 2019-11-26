package com.fff.factory;

import com.fff.service.IUserService;
import com.fff.service.impl.UserServiceImpl;

/**
 * @PACKAGE_NAME: com.fff.factory
 * @ClassName: InstanceFactory
 * @auther: RedBeanIce
 * @Date:2019/10/19 23:18
 * @<version>:1.0.0
 * @<desc>描述:
 * @<desc>描述: 模拟工厂类
 * @<desc>描述:
 * @Description: 该类可能是存在于jar包中的，是临时的存储
 */
public class InstanceFactory {
    public IUserService getUserService() {
        return new UserServiceImpl();
    }
}
