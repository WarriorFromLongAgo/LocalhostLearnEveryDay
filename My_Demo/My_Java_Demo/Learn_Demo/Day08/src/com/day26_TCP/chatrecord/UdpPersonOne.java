package com.day26_TCP.chatrecord;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpPersonOne {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String strinput = scanner.nextLine();
            DatagramPacket datagramPacket = new DatagramPacket(strinput.getBytes(), strinput.getBytes().length,
                    InetAddress.getLocalHost(), 8080);
            datagramSocket.send(datagramPacket);

        }
    }
}
