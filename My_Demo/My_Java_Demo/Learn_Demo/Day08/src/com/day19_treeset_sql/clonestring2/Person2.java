package com.day19_treeset_sql.clonestring2;

public class Person2 implements Cloneable {
    private Integer age;
    private String name;
    private Address2 address2;

    public Person2() {
    }

    public Person2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address2 getAddress2() {
        return address2;
    }

    public void setAddress2(Address2 address2) {
        this.address2 = address2;
    }

    @Override
    public String toString() {
        return "Person  {" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address2 + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person2 newPerson = (Person2) super.clone();
        newPerson.address2 = (Address2) this.address2.clone();
        return newPerson;
    }
}
