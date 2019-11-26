package com.feijm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
//        创建真实的对象
        Lenove lenove = new Lenove();
//        动态代理，增强lenove对象
//        三个参数，类加载器。接口数组，处理器

//        o，代理对象
        Object o = Proxy.newProxyInstance(Lenove.class.getClassLoader(), Lenove.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        //        调用方法
        String sale = lenove.sale(8000);
        System.out.println(sale);

        SaleComputer saleComputer = (SaleComputer) Proxy.newProxyInstance(Lenove.class.getClassLoader(), Lenove.class.getInterfaces(), new InvocationHandler() {
            /*
             * 代理逻辑的方法，代理对象saleComputer调用的所有方法，都会触发该方法的执行
             * 参数1，proxy代理对象
             * 参数2，代理对象的方法，被封装的对象
             * 参数3：代理对象调用方法时，传递的实际参数
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了。。。。。。。。。。。。");
//                System.out.println(method.getName());
//                System.out.println(args[0]);

//                使用真实对象调用该方法
                Object object = method.invoke(lenove, args[0]);
                return object;
            }
        });
        //        调用方法
        String sale2 = saleComputer.sale(8000);
        System.out.println("             " + sale2);

//        saleComputer.show();
    }

}
