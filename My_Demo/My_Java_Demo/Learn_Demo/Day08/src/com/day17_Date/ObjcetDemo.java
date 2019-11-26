package com.day17_Date;

public class ObjcetDemo {
    public static void main(String[] args) {
        ObjectD();
    }

    public static void ObjectD() {
        String strOne = "iii";
        String strTwo = "ii";
        String strThree = "iii";
        System.out.println("strOne == strOne = " + (strOne == strOne));
        System.out.println("strOne.equals(strOne) = " + strOne.equals(strOne));
        System.out.println("strOne == strTwo = " + (strOne == strTwo));
        System.out.println("strOne.equals(strTwo) = " + strOne.equals(strTwo));
        System.out.println("strOne == strThree = " + (strOne == strThree));
        System.out.println("strOne.equals(strThree) = " + strOne.equals(strThree));

        System.out.println(strOne.hashCode());


        Object objOne = "ooo";
        Object objTwo = "oo";
        Object objThree = new Object();
        objThree = "ooo";
        System.out.println(" objOne = ooo ");
        System.out.println(" objTwo = oo ");
        System.out.println( "objThree = ooo " );
        System.out.println("objOne == objOne = " + (objOne == objOne));
        System.out.println("objOne.equals(objOne) = " + objOne.equals(objOne));

        System.out.println("objOne == objTwo = " + (objOne == objTwo));
        System.out.println("objOne.equals(objTwo) = " + objOne.equals(objTwo));

        System.out.println("objOne == objThree = " + (objOne == objThree));
        System.out.println("objOne.equals(objThree) = " + objOne.equals(objThree));
        System.out.println("================================");
        Object obj1 = 1;
        Object obj2 = 2;
        Object obj3 = 3;
        System.out.println("obj1 == obj1 = " + (obj1 == obj1));
        System.out.println("obj1.equals(obj1) = " + obj1.equals(obj1));

        System.out.println("obj1 == obj2 = " + (obj1 == obj2));
        System.out.println("obj1.equals(obj2) = " + obj1.equals(obj2));

        System.out.println("obj1 == obj3 = " + (obj1 == obj3));
        System.out.println("obj1.equals(obj3) = " + obj1.equals(obj3));

        System.out.println();
        Object ooo = new Object();
        System.out.println("obj1.toString() " + ooo.toString());
        ooo = 1111;
        System.out.println(ooo);
    }
}
