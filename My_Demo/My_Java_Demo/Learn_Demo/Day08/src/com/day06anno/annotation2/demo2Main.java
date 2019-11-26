package com.day06anno.annotation2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo2Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methodArr = Demo2.class.getMethods();

        Demo2 demo2 = Demo2.class.newInstance();

        for (Method method : methodArr) {
            boolean annotationPresent = method.isAnnotationPresent(TwoAnno.class);
            if (annotationPresent) {
                TwoAnno annotation = method.getAnnotation(TwoAnno.class);
                System.out.println("annotation = " + annotation);
                System.out.println("name = " + annotation.name());
                Object invoke = method.invoke(demo2);
                System.out.println(invoke);
                System.out.println();
            }
        }
    }
}
