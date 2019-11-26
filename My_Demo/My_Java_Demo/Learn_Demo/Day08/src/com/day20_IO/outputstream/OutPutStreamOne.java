package com.day20_IO.outputstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamOne {
    public static void main(String[] args) {
        String teshu = "\r\n";
        String str = "飞机借款收到回复就的说法东方闪电尽快发货就看看会发生第三方几十块的恢复健康爽肤水123abc \r\n" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快 \r\n" +
                "的恢复健康和上岛咖啡健康的环境粉红色的就看看扩扩扩扩扩绿或扩付所所的为欧若个文件恢复抗裂砂浆覅几号放假可 \r\n " +
                "视电话飞机借款收到回复就的说法东方闪电尽快发货就看看会发生第三方几十块的恢复健康爽肤水123abc" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "尽快恢复健康的环境访客数放假快乐十分就开始放假看电视放假快乐十分就开始房价快速的恢复开机会尽快的恢复健康和上岛咖啡" +
                "健康的环境粉红色的就看看扩扩扩扩扩绿或扩付所所的为欧若个文件恢复抗裂砂浆覅几号放假可视电话 end.....";

        File fileOutput = new File("D:\\two.txt");
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileOutput);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] byteArr = str.getBytes();

            bufferedOutputStream.write(byteArr, 0, byteArr.length);

            bufferedOutputStream.flush();
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(" 完成 ");
        }
    }
}
