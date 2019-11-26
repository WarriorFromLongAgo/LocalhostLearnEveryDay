package com.day06anno.annotation1;

public class demo4main {
    public static void main(String[] args) {
        AnnotationDemo annotation = demo4.class.getAnnotation(AnnotationDemo.class);
        System.out.println("address = " + annotation.address());

        boolean annotationPresent = demo4.class.isAnnotationPresent(AnnotationDemo.class);
        System.out.println(annotationPresent);
    }
}
