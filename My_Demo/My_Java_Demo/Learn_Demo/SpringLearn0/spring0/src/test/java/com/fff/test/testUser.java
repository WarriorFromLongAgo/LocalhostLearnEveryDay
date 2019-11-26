package com.fff.test;

import com.fff.dao.IUserDao;
import com.fff.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @PACKAGE_NAME: com.fff.test
 * @ClassName: testUser
 * @auther: RedBeanIce
 * @Date:2019/10/19 15:32
 * @<version>:1.0.0
 * @<desc>描述:
 * @<desc>描述:
 * @<desc>描述:
 * @Description: User测试类的编写
 */
public class testUser {

    @Test
    public void IuserDaoTest() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ApplicationContext.xml"));
        IUserDao userDao = beanFactory.getBean("IUserDao", IUserDao.class);
        int i = userDao.insertUserDao();
        System.out.println(i);
        IUserService userService = beanFactory.getBean("IUserService", IUserService.class);
        int i2 = userService.insertUserService();
        System.out.println(i);
    }

    @Test
    public void IUserDao2Test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //IUserDao userDao = applicationContext.getBean("IUserDao", IUserDao.class);
        IUserService userService = applicationContext.getBean("IUserService", IUserService.class);
        //System.out.println(userDao.insertUserDao());
        System.out.println(userService.insertUserService());
    }

}
