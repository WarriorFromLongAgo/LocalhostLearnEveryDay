package com.day27_classLoader.propertiesOne;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class day27main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        ClassLoader classLoader = day27main.class.getClassLoader();
//        InputStream resourceAsStream = classLoader.getResourceAsStream();
        properties.load(new FileInputStream("D:\\MyJAVADemo\\Day08\\src\\com\\day27_classLoader\\propertiesOne\\peizhi.properties"));


        String className = properties.getProperty("className");
        String methodName1 = properties.getProperty("methodName1");
        String methodName2 = properties.getProperty("methodName2");
        Class<?> aClass = null;
        try {
            aClass = Class.forName(className);
            Object object = aClass.newInstance();
            Method method1 = aClass.getMethod(methodName1);
            Method method2 = aClass.getMethod(methodName2, String.class);
            method2.invoke(object, "abc");
            method1.invoke(object);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
