package com.day26_TCP.chatrecord;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpPersonTwo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8080);

        while (true) {
            byte[] byteArr = new byte[1024 * 10];

            DatagramPacket datagramPacket = new DatagramPacket(byteArr, byteArr.length);
            datagramSocket.receive(datagramPacket);

            byte[] byteArr2 = datagramPacket.getData();
            int byteArr2Len = byteArr2.length;
            System.out.println(datagramPacket.getAddress().getHostName() + ": " + new String(byteArr2, 0, byteArr2Len));
        }
    }
}
