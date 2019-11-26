package com.day26_TCP.day26homework;

//         1.提示用户输入用户名和密码,将用户输入的用户名和密码发送给服务端
//         2.接收服务端验证完用户名和密码的结果

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostName(), 10086);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = scanner.nextLine();
        System.out.println("请输入密码");
        String passWord = scanner.nextLine();

        String merge = userName + "=" + passWord;
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        printWriter.println(merge);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readServerStr = bufferedReader.readLine();
        System.out.println(readServerStr);
    }
}
