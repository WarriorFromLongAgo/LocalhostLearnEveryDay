package com.day26_TCP.day26homework;

//1.接收客户端发送过来的用户名和密码
//        2.如果用户名不是bianyiit或者 密码不是123456,就向客户端写入”登录失败”
//        否则向客户端写入登录成功


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10086);

        while (true) {
            Socket accept = server.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            String merge = bufferedReader.readLine();
            String userName = merge.split("=")[0];
            String passWord = merge.split("=")[1];

            String result = "";
            if ("bianyiit".equals(userName) && "123456".equals(passWord)) {
                result = "登录成功";
            } else {
                result = "登录失败";
            }
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()), true);
            printWriter.println(result);
        }
    }
}
