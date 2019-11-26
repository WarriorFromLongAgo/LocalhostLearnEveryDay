package com.day26_TCP.EchoTcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    private static class MythreadService implements Runnable {
        private Socket accept;

        public MythreadService(Socket accept) {
            this.accept = accept;
        }

        @Override
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()), true);

                boolean flag = true;
                while (flag) {
                    String str = null;
                    if ((str = bufferedReader.readLine().trim()) != null) {
                        if ("byebye".equalsIgnoreCase(str)) {
                            printWriter.println("BYEBYE!!! ");
                            flag = false;
                            break;
                        }
                        printWriter.println("ECHO : " + str);
                    }
                }

                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);

        boolean flag = true;
        while (flag) {
            Socket accept = serverSocket.accept();
            new Thread(new MythreadService(accept)).start();
        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
//
//        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()), true);
//
//        boolean flag = true;
//        while (flag) {
//            String str = null;
//            if ((str = bufferedReader.readLine().trim()) != null) {
//                if ("byebye".equalsIgnoreCase(str)) {
//                    printWriter.println("BYEBYE!!! ");
//                    flag = false;
//                    break;
//                }
//                printWriter.println("ECHO : " + str);
//            }
//
//        }
//
//        bufferedReader.close();
        serverSocket.close();
    }
}
