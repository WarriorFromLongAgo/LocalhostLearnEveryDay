package com.day26_TCP.EchoTcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clien = new Socket(InetAddress.getLocalHost(), 10086);

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clien.getInputStream()));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(clien.getOutputStream()), true);

        boolean flag = true;
        while (flag) {
            System.out.println("请输入要输入的信息");
            String str = null;
            if (scanner.hasNext()) {
                str = scanner.nextLine().trim();
                printWriter.println(str);

                String strServer = null;
                if ((strServer = bufferedReader.readLine().trim()) != null) {
                    System.out.println(strServer);
                }
            }
            if ("byebye".equalsIgnoreCase(str)) {
                flag = false;
                break;
            }
        }
        scanner.close();
        clien.close();
    }
}
