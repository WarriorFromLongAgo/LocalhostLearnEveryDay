package com.day19_treeset_sql.student;

import java.util.ArrayList;

public class StudentDeal {
    ArrayList<Student> studentArr = new ArrayList<>();

    public void addStudent(Student student) {
        if (studentArr.size() == 0) {
            studentArr.add(student);
            return;
        }
        //  如果传入的student.age < studentArr首个元素
        //  则在studentArr 首部插入
        if (student.getAge() < studentArr.get(0).getAge()) {
            studentArr.add(0, student);
            //  如果传入的student.age > studentArr最后一个元素
            //  则在studentArr 尾部插入
        } else if (student.getAge() > studentArr.get(studentArr.size() - 1).getAge()) {
            studentArr.add(student);
        } else {
            //  否则就在中间插入
            //  检查在哪里插入，从1 开始遍历
            for (int i = 1; i < studentArr.size(); i++) {
                //  如果插入的元素，大于i处的元素，则继续向后迁移
                if (student.getAge() > studentArr.get(i).getAge()) {
                    continue;
                } else {
                    //  小于i处的元素，则在i处插入
                    studentArr.add(i, student);
                    return;
                }
            }
        }
    }

    public ArrayList<Student> disPlayAllData() {
        return this.studentArr;
    }
}
