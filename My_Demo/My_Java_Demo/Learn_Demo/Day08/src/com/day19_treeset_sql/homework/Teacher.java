package com.day19_treeset_sql.homework;

//public class Teacher implements Comparator {
public class Teacher implements Comparable {
    private String teacherId;
    private String teacherName;
    private int age;
    private String address;

    public Teacher() {
    }

    public Teacher(String teacherName, int age, String address) {
        this.teacherName = teacherName;
        this.age = age;
        this.address = address;
    }

    public Teacher(String teacherId, String teacherName, int age, String address) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.age = age;
        this.address = address;
    }

    public String getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Teacher teacherOne = (Teacher) o;
        if (this.age > teacherOne.age) {
            return 1;
        }
        if (this.age < teacherOne.age) {
            return -1;
        }
        if (this.age == teacherOne.age) {
            if (this.teacherName.compareToIgnoreCase(teacherOne.teacherName) > 0) {
                return 1;
            }
            if (this.teacherName.compareToIgnoreCase(teacherOne.teacherName) < 0) {
                return -1;
            }
            if (this.teacherName.compareToIgnoreCase(teacherOne.teacherName) == 0) {
                return 0;
            }
        }
        return 0;
    }

//    @Override
//    public int compare(Object objOne, Object objTwo) {
//        Teacher teacherOne = (Teacher) objOne;
//        Teacher teacherTwo = (Teacher) objTwo;
//        if (teacherOne.age > teacherTwo.age) {
//            return 1;
//        }
//        if (teacherOne.age < teacherTwo.age) {
//            return -1;
//        }
//        if (teacherOne.age == teacherTwo.age) {
//            if (teacherOne.teacherId.compareToIgnoreCase(teacherTwo.teacherId) > 0) {
//                return 1;
//            }
//            if (teacherOne.teacherId.compareToIgnoreCase(teacherTwo.teacherId) < 0)  {
//                return -1;
//            }
//            if (teacherOne.teacherId.compareToIgnoreCase(teacherTwo.teacherId) == 0)  {
//                if (teacherOne.teacherName.compareToIgnoreCase(teacherTwo.teacherName) > 0) {
//                    return 1;
//                }
//                if (teacherOne.teacherName.compareToIgnoreCase(teacherTwo.teacherName) < 0) {
//                    return -1;
//                }
//                if (teacherOne.teacherName.compareToIgnoreCase(teacherTwo.teacherName) == 0) {
//                    return 0;
//                }
//            }
//        }
//        return 0;
//    }

}
