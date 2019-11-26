package com.day19_treeset_sql.clonestring2;


public class CloneString {
    public static void main(String[] args) throws CloneNotSupportedException {
        //qianClone();
        Person2 onePerson2 = new Person2(20, "feijm");
        Address2 address2 = new Address2("湖南");

        onePerson2.setAddress2(address2);
        Person2 twoPerson = (Person2) onePerson2.clone();

        twoPerson.getAddress2().setAddress2("广东深圳");

        System.out.println(onePerson2.getAddress2().getAddress2());
        System.out.println("twoPerson = " + onePerson2);

        System.out.println(twoPerson.getAddress2().getAddress2());
        System.out.println("twoPerson = " + twoPerson);
    }
}
