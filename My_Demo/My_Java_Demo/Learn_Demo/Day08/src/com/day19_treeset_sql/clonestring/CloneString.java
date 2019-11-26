package com.day19_treeset_sql.clonestring;

public class CloneString {
    public static void main(String[] args) throws CloneNotSupportedException {
        //qianClone();
        Person onePerson = new Person(20, "feijm");
        Address address = new Address("湖南");

        onePerson.setAddress(address);
        Person twoPerson = (Person) onePerson.clone();

        twoPerson.getAddress().setAddress("广东深圳");
        System.out.println(onePerson.getAddress().getAddress());
        System.out.println("onePerson = " + onePerson);
    }

    private static void qianClone() throws CloneNotSupportedException {
        Person onePerson = new Person(20, "feijm");

        Address address = new Address("湖南");

        onePerson.setAddress(address);

        Person twoPerson = (Person) onePerson.clone();

        System.out.println("onePerson = " + onePerson);
        System.out.println("twoPerson = " + twoPerson);

        System.out.println("onePerson==twoPerson = " + (onePerson == twoPerson));
        System.out.println("onePerson.getAddress() == twoPerson.getAddress() = "
                + (onePerson.getAddress() == twoPerson.getAddress()));
    }
}
