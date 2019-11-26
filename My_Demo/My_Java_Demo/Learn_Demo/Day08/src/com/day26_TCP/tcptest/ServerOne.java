package com.day26_TCP.tcptest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOne {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);

        while (true) {
            Socket accept = serverSocket.accept();

//            InputStream inputStream = accept.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

            String readClientInfo = bufferedReader.readLine();
            readClientInfo = readClientInfo + System.lineSeparator() + "abcdefg";
            System.out.println(readClientInfo);

            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()), true);
//            PrintWriter printWriter2 = new PrintWriter(accept.getOutputStream(),true);
            printWriter.println(readClientInfo);
//            printWriter2.println(readClientInfo.toUpperCase());
            printWriter.close();
        }

    }
}
