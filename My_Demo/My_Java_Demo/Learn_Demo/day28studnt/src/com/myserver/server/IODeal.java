//package com.myserver.server;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class IODeal {
//    public static void ioClose(BufferedReader bufferedReader) {
//        try {
//            if (bufferedReader != null) {
//                bufferedReader.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String ioRead(ServerSocket server, Socket accept, BufferedReader bufferedReader,
//                                String readClientAddTask) throws IOException {
//        accept = server.accept();
//        bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
//        readClientAddTask = bufferedReader.readLine();
//        System.out.println("接收到的信息为 = " + readClientAddTask);
//        return readClientAddTask;
//    }
//}
