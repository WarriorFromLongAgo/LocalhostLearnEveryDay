package com.day20_IO.fiilebase;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Day20FileOne {
    public static void main(String[] args) throws IOException {
//        ConstructorOne();
//        ConstructorTwo();
//        constructorThree();
//        constructorFour();
//        constructorFive();
//        creatMikdirsDelete();
//        creatMikdirsDeleteTwo();
        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 canExecute() ");
        System.out.println(" 测试应用程序是否可以执行此抽象路径名表示的文件。");
        File fileOne = new File("D:\\one.txt");
        File fileTwo = new File("D:\\one.txt");
        boolean b = fileOne.canExecute();
        System.out.println("fileOne.canExecute = " + b);

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 canRead() ");
        System.out.println(" 测试应用程序是否可以读取由此抽象路径名表示的文件。");
        fileOne = new File("D:\\one.txt");
        b = fileOne.canRead();
        System.out.println("fileOne.canRead = " + b);

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 canWrite() ");
        System.out.println(" 测试应用程序是否可以修改由此抽象路径名表示的文件。");
        fileOne = new File("D:\\one.txt");
        b = fileOne.canWrite();
        System.out.println("fileOne.canWrite() = " + b);

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 canWrite() ");
        System.out.println(" 测试应用程序是否可以修改由此抽象路径名表示的文件。");
        fileOne = new File("D:\\one.txt");
        fileTwo = new File("D:\\two.txt");
        int tempcompare = fileOne.compareTo(fileTwo);
        System.out.println("fileOne.compareTo(fileTwo) = " + tempcompare);

        System.out.println("===============================================================");
        System.out.println(" 返回 static File    返回 createTempFile(String prefix, String suffix)   ");
        System.out.println(" 返回 static File    返回 createTempFile(String prefix, String suffix, File directory)  ");
        System.out.println(" 在默认临时文件目录中创建一个空文件，使用给定的前缀和后缀生成其名称。");
        System.out.println(" 在指定的目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称。 ");
        File fileThree = new File("D:\\电脑必备");
        File three = File.createTempFile("threee", ".txt", fileThree);
        System.out.println("File.createTem pFile(\"three\", \".txt\", fileThree) = " + three);

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 exists()  ");
        System.out.println(" 测试此抽象路径名表示的文件或目录是否存在。");
        fileOne = new File("D:\\one.txt");
        b = fileOne.exists();
        System.out.println("fileOne.canWrite() = " + b);

        System.out.println("===============================================================");
        System.out.println(" 返回 File    返回 getAbsoluteFile()   ");
        System.out.println(" 返回 String    返回 getAbsolutePath()   ");
        System.out.println(" 返回此抽象路径名的绝对形式。");
        System.out.println(" 返回此抽象路径名的绝对路径名字符串。");
        fileOne = new File("D:\\one.txt");
        fileThree = fileOne.getAbsoluteFile();
        System.out.println("fileOne.getAbsoluteFile() = " + fileThree);
        String strOne = fileOne.getAbsolutePath();
        System.out.println("fileOne.getAbsoluteFile() = " + strOne);

        System.out.println("===============================================================");
        System.out.println(" 返回 File    返回 getCanonicalFile()   ");
        System.out.println(" 返回 String    返回 getCanonicalPath()   ");
        System.out.println(" 返回此抽象路径名的规范形式。");
        System.out.println(" 返回此抽象路径名的规范路径名字符串。");
        fileOne = new File("D:\\one.txt");
        fileThree = fileOne.getCanonicalFile();
        System.out.println("fileOne.getAbsoluteFile() = " + fileThree);
        strOne = fileOne.getCanonicalPath();
        System.out.println("fileOne.getAbsoluteFile() = " + strOne);

        System.out.println("===============================================================");
        System.out.println(" 返回 String    返回 getName()   ");
        System.out.println(" 返回 String    返回 getParent()   ");
        System.out.println(" 返回 File    返回 getParentFile()  ");
        System.out.println(" 返回 String    返回 getPath()  ");
        System.out.println(" 返回由此抽象路径名表示的文件或目录的名称。");
        System.out.println(" 返回此抽象路径名的父 null的路径名字符串，如果此路径名未命名为父目录，则返回null。");
        System.out.println(" 返回此抽象路径名的父，或抽象路径名 null如果此路径名没有指定父目录。");
        System.out.println(" 将此抽象路径名转换为路径名字符串。");
        fileOne = new File("D:\\电脑必备\\one\\one.txt");
        strOne = fileOne.getName();
        System.out.println("fileOne.getName() = " + strOne);
        strOne = fileOne.getParent();
        System.out.println("fileOne.getParent() = " + strOne);
        fileTwo = fileOne.getParentFile();
        System.out.println("fileTwo.getParentFile() = " + fileTwo);
        strOne = fileOne.getPath();
        System.out.println("fileOne.getPath() = " + strOne);

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 isAbsolute()  ");
        System.out.println(" 返回 boolean    返回 isDirectory()   ");
        System.out.println(" 返回 boolean    返回 isFile()    ");
        System.out.println(" 测试这个抽象路径名是否是绝对的。");
        System.out.println(" 测试此抽象路径名表示的文件是否为目录。");
        System.out.println(" 测试此抽象路径名表示的文件是否为普通文件。");
        fileOne = new File("D:\\电脑必备\\one");
        b = fileOne.isAbsolute();
        System.out.println("fileOne.isAbsolute() = " + b);
        b = fileOne.isDirectory();
        System.out.println("fileOne.isDirectory() = " + b);
        b = fileOne.isFile();
        System.out.println("fileOne.isFile() = " + b);

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 isHidden()   ");
        System.out.println(" 返回 long    返回 lastModified()    ");
        System.out.println(" 返回 long    返回 length()     ");
        System.out.println(" 测试这个抽象路径名是否是绝对的。");
        System.out.println(" 测试此抽象路径名表示的文件是否为目录。");
        System.out.println(" 测试此抽象路径名表示的文件是否为普通文件。");
        fileOne = new File("D:\\电脑必备\\one\\one.txt");
        b = fileOne.isHidden();
        System.out.println("fileOne.isHidden() = " + b);
        long time = fileOne.lastModified();
        Date date = new Date(time);
        System.out.println("fileOne.lastModified() = " + date);
        long len = fileOne.length();
        System.out.println("fileOne.length() = asdfghjkl =  " + len);

        System.out.println("===============================================================");
        System.out.println(" 返回 String[]    返回 list()   ");
        System.out.println(" 返回 File[]   返回 listFiles()   ");
        System.out.println(" 返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。");
        System.out.println(" 返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件和目录");
        fileOne = new File("D:\\电脑必备\\one");
        String[] strList = fileOne.list();
        //  one - 副本 (2).txt
        for (String string : strList) {
            System.out.print(string + ",,");
        }
        System.out.println();
        File[] fileArr = fileOne.listFiles();
        //  D:\电脑必备\one\one - 副本 (2).txt
        for (File file : fileArr) {
            System.out.print(file + ",,");
        }
        System.out.println();

        System.out.println("===============================================================");
        System.out.println(" 返回 static File[]    返回 listRoots()   ");
        System.out.println(" 列出可用的文件系统根。其实就是几个盘符");
        fileOne = new File("D:\\电脑必备\\one");
        File[] fileArrTwo = File.listRoots();
        for (File file : fileArrTwo) {
            System.out.print(file + ",,");
        }
        System.out.println();

        System.out.println("===============================================================");
        System.out.println(" 返回 boolean    返回 renameTo()   ");
        System.out.println(" 重命名文件 ");
        fileOne = new File("D:\\电脑必备\\one\\one.txt");
        boolean renameFlag = fileOne.renameTo(new File("D:\\电脑必备\\one\\oneone.txt"));
        System.out.println("fileOne.renameTo = " + renameFlag);
    }

    private static void creatMikdirsDeleteTwo() {
        File fileOne = new File("D://temp/temp1/temp2");
        boolean mkdirsFlag = fileOne.mkdirs();
        File fileTwo = new File("D://temp/tempOne");
        boolean mkdirFlag = fileTwo.mkdir();
        System.out.println("添加多个文件夹 = " + mkdirsFlag);
        System.out.println("添加一个文件夹 = " + mkdirFlag);


        File fileThree = new File("D://temp/tempOne/one.txt");
        boolean newFileFlag = false;
        try {
            newFileFlag = fileThree.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建文件成功 = " + newFileFlag);

        fileThree.deleteOnExit();
        System.out.println("删除文件成功");

        File fileFour = new File("D://temp/tempOne");
        fileFour.deleteOnExit();
        System.out.println("删除文件夹成功");
    }

    private static void creatMikdirsDelete() {
        File fileOne = new File("D://temp/temp1/temp2");
        boolean mkdirsFlag = fileOne.mkdirs();
        File fileTwo = new File("D://temp/tempOne");
        boolean mkdirFlag = fileTwo.mkdir();
        System.out.println("添加多个文件夹 = " + mkdirsFlag);
        System.out.println("添加一个文件夹 = " + mkdirFlag);


        File fileThree = new File("D://temp/tempOne/one.txt");
        boolean newFileFlag = false;
        try {
            newFileFlag = fileThree.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建文件成功 = " + newFileFlag);

        boolean deleteFlag = fileThree.delete();
        System.out.println("删除文件成功= " + deleteFlag);

        File fileFour = new File("D://temp/tempOne");
        boolean deleteFlagTwo = fileFour.delete();
        System.out.println("删除文件夹成功= " + deleteFlagTwo);
    }

    private static void constructorFive() {
        File fileParent = new File("D:\\Program Files (x86)");
        File fileChild = new File(fileParent, "three.txt");
        boolean newFileFlag = false;

        try {
            newFileFlag = fileChild.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println(newFileFlag);
    }

    private static void constructorFour() {
        //  会在最 根的目录进行创建
        File fileParent = new File("D:\\");
        File fileChild = new File("three.txt");
        boolean newFileFlag = false;

        try {
            newFileFlag = fileChild.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println(newFileFlag);
    }

    private static void constructorThree() {
        //  会在最 根的目录进行创建
        File fileParent = new File("d:");
        File fileChild = new File("three.txt");
        boolean newFileFlag = false;

        try {
            newFileFlag = fileChild.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println(newFileFlag);
    }

    private static void ConstructorTwo() {
        File fileTwo = new File("d:\\", "two.txt");
        boolean newFileFlag = false;

        try {
            newFileFlag = fileTwo.createNewFile();
        } catch (IOException e) {
            e.getMessage();
            e.toString();
            e.printStackTrace();
        }

        System.out.println(newFileFlag);
    }

    private static void ConstructorOne() {
        File fileOne = new File("D:\\one.txt");
        boolean newFileFlag = false;

        try {
            newFileFlag = fileOne.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFileFlag);
    }
}
