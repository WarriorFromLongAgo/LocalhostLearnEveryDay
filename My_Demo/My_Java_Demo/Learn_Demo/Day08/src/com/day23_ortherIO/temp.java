package com.day23_ortherIO;

import java.io.*;

//srcFile.txt内容如下:
//        abc123def
//        ghik5e67p

//  destFile.txt

public class temp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("srcFile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("destFile.txt"));
        String line = null;
        while (null != (line = br.readLine())) {
            char[] arr = line.toCharArray();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] >= '0' && arr[i] <= '9') {
                    sb.append(arr[i] + "");
                }
            }
            //123567
            char[] chs = sb.toString().toCharArray();
            int value = 0;

            for (int i = 0; i < chs.length; i++) {

                if (value < Integer.parseInt(chs[i] + "")) {

                    value = Integer.parseInt(chs[i] + "");
                }

            }
            bw.write(value + "");
            bw.newLine();
        }
        br.close();
        bw.close();
    }


}
