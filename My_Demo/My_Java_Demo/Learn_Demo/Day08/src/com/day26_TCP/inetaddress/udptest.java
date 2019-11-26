package com.day26_TCP.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class udptest {
    public static void main(String[] args) throws UnknownHostException {
//        返回本地主机的地址。
//        返回 inetaddress  方法类型    static
        InetAddress localHost = InetAddress.getLocalHost();
//        biantai-PC/192.168.2.111
//        biantai-PC/192.168.199.220
        System.out.println(localHost);
//        返回回送地址。
//        返回 inetaddress    方法类型  static
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
//        localhost/127.0.0.1
        System.out.println(loopbackAddress);

//        -64-882111    InetAddress对象的原始IP地址。
//        -64-88-57-36
        byte[] address = localHost.getAddress();
        for (byte b : address) {
            System.out.print(b);
        }
        System.out.println();

        //  127001    InetAddress对象的原始IP地址。
        byte[] address1 = loopbackAddress.getAddress();
        for (byte b : address1) {
            System.out.print(b);
        }
        System.out.println();

//        返回的是  主机的名称 和 IPV4的地址
//        返回的是  主机的名称 和 IPV6的地址
//        给定主机的名称，根据系统上配置的名称服务返回其IP地址数组
//        biantai-PC/192.168.2.111
//        biantai-PC/fe80:0:0:0:388c:478:59ab:a0a5%12
//        biantai-PC/192.168.199.220
//        biantai-PC/fe80:0:0:0:388c:478:59ab:a0a5%12
        InetAddress[] allByName1 = InetAddress.getAllByName(localHost.getHostName());
        for (InetAddress inetAddress1 : allByName1) {
            System.out.println(inetAddress1);
        }

//        localhost/127.0.0.1
//        localhost/0:0:0:0:0:0:0:1
        InetAddress[] allByName2 = InetAddress.getAllByName(loopbackAddress.getHostName());
        for (InetAddress inetAddress1 : allByName2) {
            System.out.println(inetAddress1);
        }

//        byte[] byteArr = new byte[1024 * 1024 * 30];
//        inetaddress byAddress = inetaddress.getByAddress(byteArr);
//        System.out.println(byAddress);
//
//        inetaddress byAddress1 = inetaddress.getByAddress(inetaddress.getLocalHost().getHostName(), byteArr);
//        System.out.println(byAddress1);

        System.out.println("-----------------------------");

//        biantai-PC/192.168.2.111 确定主机名称的IP地址。
//        biantai-PC/192.168.199.220
        InetAddress byName = InetAddress.getByName(localHost.getHostName());
        System.out.println(byName);
//        localhost/127.0.0.1
        InetAddress byName2 = InetAddress.getByName(loopbackAddress.getHostName());
        System.out.println(byName2);

//        biantai-PC        获取此IP地址的完全限定域名。
//        biantai-PC.lan
        String canonicalHostName = localHost.getCanonicalHostName();
        System.out.println(canonicalHostName);
//        activate.navicat.com      获取此IP地址的完全限定域名。
        String canonicalHostName1 = loopbackAddress.getCanonicalHostName();
        System.out.println(canonicalHostName1);

//        192.168.2.111     返回文本显示中的IP地址字符串。
//        192.168.199.220
        System.out.println(localHost.getHostAddress());
//        127.0.0.1     返回文本显示中的IP地址字符串。
        System.out.println(loopbackAddress.getHostAddress());

        System.out.println("-----------------------------");

//        biantai-PC    获取此IP地址的主机名
        System.out.println(localHost.getHostName());
//        localhost     获取此IP地址的主机名。
        System.out.println(loopbackAddress.getHostName());




    }

}
