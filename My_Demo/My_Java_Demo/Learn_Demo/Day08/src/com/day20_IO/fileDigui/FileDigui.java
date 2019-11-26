package com.day20_IO.fileDigui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDigui {
    public static void main(String[] args) {

        File file = new File("D:\\java编\\JAVA101");
        List<File> fileList = new ArrayList<>();
        fileDigui(file, fileList);
//        fileDigui3(file);
        //fileDigui(file);
//        fileDigui4(file);
        System.out.println("===========================");
        for (int i = 0; i < fileList.size(); i++) {

        }
    }

    public static void fileDigui4(File file) {
        //当文件不存在时，不允许进入
        if (file.isDirectory()) {
            //干掉自己所有的子文件和子目录
            //获取所有的子文件和子目录
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    //直接干掉他
                    System.out.println(f.getName());
                    //f.delete();
                } else if (f.isDirectory()) {
                    //继续查看是否还有文件和子目录
                    fileDigui4(f);
                }
            }
            //干掉自己
            System.out.println(file.getName());
            //file.delete();
        }
    }


//    public static void fileDigui3(File file) {
//        //当文件不存在时，不允许进入
//        if (file.isDirectory()) {
//            //  取得当前文件夹的文件目录与文件
//            File[] fileArr = file.listFiles();
//
//            for (int i = 0; i < fileArr.length; i++) {
//                //  如果是文件夹
//                if (fileArr[i].isDirectory()) {
//
//                    fileList.add(fileArr[i]);
//                    //  则进入再次递归
//                    fileDigui3(fileArr[i]);
//                } else {
//                    //  如果是文件，则进行文件的删除
////                    isDirectory()
////                    测试此抽象路径名表示的文件是否为目录。
//                    fileArr[i].delete();
//                }
//            }
//            for (int i = fileList.size() - 1; i > 0; i--) {
//                fileList.get(i).delete();
//            }
//            file.delete();
//        } else {
//            return;
//        }
//    }

    private static void fileDigui(File file, List<File> fileList) {
        File[] fileArr = file.listFiles();
        for (int i = 0; i < fileArr.length; i++) {
            if (fileArr[i].isDirectory()) {
                System.out.println("目录 = " + fileArr[i]);
                fileDigui(fileArr[i], fileList);
            } else {
                System.out.println(fileArr[i]);
                fileList.add(fileArr[i]);
            }
        }
    }

    private static void fileDigui2(File file) {
        File[] fileArr = file.listFiles();

        for (File file1 : fileArr) {
            if (file1.isDirectory()) {
                System.out.println("目录 = " + file1);
                fileDigui2(file1);
            } else {
                System.out.println(file1);
            }
        }
    }
}
