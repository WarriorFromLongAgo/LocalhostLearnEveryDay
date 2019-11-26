package com.day26_TCP.tcptest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientOne {
    public static void main(String[] args) throws IOException {
//        Object obj = "192.168.199.220";
//        Socket client = new Socket(InetAddress.getLocalHost(), 10086);
//        InetAddress inetAddress = (InetAddress) obj;
        Socket client = new Socket(InetAddress.getLocalHost().getHostName(), 10086);
        //  两种都可以
//
//
//        int port = client.getPort();
//
//        System.out.println(port);
//
//        //  本地的端口
//        int localPort = client.getLocalPort();
//        System.out.println(localPort);
//
//        InetAddress localAddress = client.getLocalAddress();
//        System.out.println(localAddress);


        Scanner scanner = new Scanner(System.in);
//        OutputStream outputStream = client.getOutputStream();
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
////        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//        PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);

        printWriter.println(scanner.nextLine());


//        InputStream inputStream = client.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String tempStr = null;
        while ((tempStr = bufferedReader.readLine()) != null) {
            String readServerInfo = tempStr;
            System.out.println(readServerInfo);
        }
        scanner.close();
        client.close();
    }
}
