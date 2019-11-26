package com.day19_treeset_sql.treeset;

public class Student implements Comparable {
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  hashCode    equals  写的是hashSet的判断重复
//    @Override
//    public int hashCode() {
//        return this.id;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        Constructor Constructor = (Constructor) obj;
//        return this.id == Constructor.id;
//    }

    @Override
    public String toString() {
        return "Constructor{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object object) {
        Student student = (Student) object;
        if (this.age > student.age) {
            return 1;
        } else if (this.age == student.age) {
            if (this.id > student.id) {
                return 1;
            } else if (this.id == student.id) {
                if (this.name.compareToIgnoreCase(student.name) > 0) {
                    return 1;
                } else if (this.name.compareToIgnoreCase(student.name) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
