package com.fff;

import org.springframework.boot.SpringApplication;

/**
 * @PackageName：com.fff.main
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/14 21:13
 */
/*标注springboot的引导类*/
public class MySpringBootApplication {
    public static void main(String[] args) {
        /*run方法，运行springboot的引导类*/
        SpringApplication.run(BootBean.class);
    }
}
