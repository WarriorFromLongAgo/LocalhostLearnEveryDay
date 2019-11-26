package com.feijm.model.entity;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String birthplace;
    private String qqAccount;
    private String mailbox;
    private String temp1;
    private String temp2;
    private String temp3;

    public Student() {
    }
    public Student(String name, String sex, Integer age, String birthplace, String qqAccount, String mailbox) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthplace = birthplace;
        this.qqAccount = qqAccount;
        this.mailbox = mailbox;
    }

    public Student(Integer id, String name, String sex, Integer age, String birthplace, String qqAccount, String mailbox) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthplace = birthplace;
        this.qqAccount = qqAccount;
        this.mailbox = mailbox;
    }

    public Student(Integer id, String name, String sex, Integer age, String birthplace, String qqAccount, String mailbox, String temp1, String temp2, String temp3) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthplace = birthplace;
        this.qqAccount = qqAccount;
        this.mailbox = mailbox;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthplace='" + birthplace + '\'' +
                ", qqAccount='" + qqAccount + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", temp1='" + temp1 + '\'' +
                ", temp2='" + temp2 + '\'' +
                ", temp3='" + temp3 + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }
}
