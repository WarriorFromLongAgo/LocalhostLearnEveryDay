package com.day22_IO_SQL.day22homework;

import com.day22_IO_SQL.day22homework.mysqldeal.ReadToMysql;
import com.day22_IO_SQL.day22homework.mysqldeal.TestMysql;

import java.util.HashMap;
import java.util.Map;

public class homeMain {
    public static void main(String[] args) {

        //  得到创建的20个对象
        Map<Integer, Student> intStudentMap = forCreateObject();
//        //  将得到的20个对象，全部存进txt文件中
//        writerIO writerIO = new writerIO();
//        writerIO.writerToFile(intStudentMap);
//
//        readIO readIo = new readIO();
//        readIo.readToConsole();

        //  测试sql是否可以连接的代码
        TestMysql testMysql = new TestMysql();
        testMysql.testMysql();
//        //  创建一个表
//        CreatTableMysql creatTableMysql = new CreatTableMysql();
//        creatTableMysql.creatTable();
//        //  将数据插入到数据库
//        InsertToMysql insertToMysql = new InsertToMysql();
//        insertToMysql.insertMysql(intStudentMap);
        //  读取数据库到控制台
        ReadToMysql readToMysql = new ReadToMysql();
        readToMysql.readToMysql();
    }


    public static Map<Integer, Student> forCreateObject() {
        //  创建20个对象
        Map<Integer, Student> studentIntStudentMap = new HashMap<>(20);
        int count = 20;
        int stuId = 10001;
        for (int i = 0; i < 20; i++) {
            studentIntStudentMap.put(stuId, new Student(stuId++, "万" + (i + 1), count--, "java101"));
        }
        return studentIntStudentMap;
    }

//
//    public static Map<Integer, Constructor> createObject() {
//        //  创建20个对象
//        int studentId = 10001;
//        Map<Integer, Constructor> studentIntStudentMap = new HashMap<>(20);
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万1", 20, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万2", 19, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万3", 18, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万4", 17, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万5", 16, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万6", 15, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万7", 14, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万8", 13, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万9", 12, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万10", 11, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万11", 10, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万12", 9, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万13", 8, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万14", 7, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万15", 6, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万16", 5, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万17", 4, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万18", 3, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万19", 2, "java101"));
//        studentIntStudentMap.put(studentId, new Constructor(studentId++, "万20", 1, "java101"));
////        for (Map.Entry<Integer, Constructor> intStudentEntry : studentIntStudentMap.entrySet()) {
////            System.out.print("key = " + intStudentEntry.getValue().getStudentId());
////            System.out.println(",value = " + intStudentEntry.getValue().toString());
////        }
//        return studentIntStudentMap;
//    }
}
