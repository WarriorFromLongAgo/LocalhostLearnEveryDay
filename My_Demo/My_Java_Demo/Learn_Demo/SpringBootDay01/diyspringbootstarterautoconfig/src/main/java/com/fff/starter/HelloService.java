package com.fff.starter;

/**
 * @PackageName：com.fff.starter
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/18 21:26
 */
public class HelloService {


    HelloProperties helloProperties;


    public String sayHello(String name) {
        String s = helloProperties.getPrefix() +
                "---" + name + "---" + helloProperties.getSuffix();

        System.out.println(s);
        return s;
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
