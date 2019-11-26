package com.fff.factory;

import com.fff.service.IUserService;
import com.fff.util.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @PackageName：com.fff.factory
 * @ClassName：
 * @Description：用于创建service的代理对象的工厂
 * @author：
 * @date：2019/10/21 15:05
 */
public class BeanFactory {

    private IUserService userService;
    private TransactionManager transactionManager;

    public final void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IUserService getUserService() {
        Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //                    添加事务的支持
                    //  proxy是我们创建的代理对象
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;

                        try {
                            transactionManager.beginTransaction();
                            returnValue = method.invoke(userService, args);
                            transactionManager.commitTransaction();
                            return returnValue;

                        } catch (Exception e) {
                            transactionManager.rollbackTransaction();
                            throw new RuntimeException(e);

                        } finally {
                            transactionManager.releaseTransaction();
                        }
                    }
                });

        return userService;
    }


}
