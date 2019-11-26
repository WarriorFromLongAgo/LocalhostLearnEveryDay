//package com.day23_ortherIO;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//
////        a1Bc2De3F
////        G4h5I6jK
//
//
//public class temp3 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("srcFile.txt"));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("destFile.txt"));
//        String line = null;
//
//        while (null != (line = br.readLine())) {
//
//            char[] arr = line.toCharArray();
//            StringBuilder sb = new StringBuilder();
//
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] >= '0' && arr[i] <= '9') {
//                    sb.append(arr[i] + "");
//                }
//            }
//            bw.write(sb.toString());
//            bw.newLine();
//        }
//        br.close();
//        bw.close();
//    }
//
//}
