package com.byit.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SArraryListGrammer {
    public static void main(String[] args) {
        MyArraryList myArraryList = new MyArraryList();
        myArraryList.addMethod();
    }
}

class MyArraryList {
    private String strOne = "1111";
    private String strTwo = "2222";
    private String strThree = "3333";
    private int intOne = 1111;
    private byte byteOne = 100;
    private double doubleOne = 10.0;

    ArrayList<Integer> myIntArrList = new ArrayList<>();
    ArrayList<String> myStrArrList = new ArrayList<>();
    ArrayList<Byte> myByteArrList = new ArrayList<>();
    ArrayList<Double> myDoubleArrList = new ArrayList<>();
    String[] strNum = new String[]{"1000", "2000", "3000"};
    ArrayList<String> myTwoStrArrList = new ArrayList<>();
    ArrayList<Object> myObjArrList = new ArrayList<>();

//    public ArraryList(){
//        System.out.println("ArraryList 的初始长度为 10");
//    }

    public void addMethod() {
        String tempStrOne = "1000";
        String tempStrTwo = "2000";
        String tempStrThree = "3000";

        System.out.println("1，返回 boolean，方法：add(E e)");
        //1，返回 boolean，方法：add(E e)
        //添加一个 对应数据类型 的元素在末尾。返回的是true
        System.out.println("添加 " + myIntArrList.add(intOne));
        //不允许 将不同类型添加到 链表后面
        //System.out.println("添加 "+myIntArrList.add(strOne));
        System.out.println("添加 " + myStrArrList.add(strOne));
        System.out.println("添加 " + myByteArrList.add(byteOne));
        System.out.println("添加 " + myDoubleArrList.add(doubleOne));
        //返回四个true
        System.out.println("=====================================");
        System.out.println("2，返回 void，方法：add(int index, E element)");
        //2，返回 void，方法：add(int index, E element)
        //添加一个对应数据类型的元素，在指定位置index处
        myStrArrList.add(0, strTwo);
        myStrArrList.add(0, strThree);
        myStrArrList.add(0, strOne);
        myTwoStrArrList.add(tempStrOne);
        myTwoStrArrList.add(tempStrTwo);
        myTwoStrArrList.add(tempStrThree);

        System.out.println("=====================================");
        //3，返回 E，方法：get(int index)
        //返回此列表中指定位置的元素。
        //4，返回 int，方法：size()
        //返回此列表中的元素数。也就是长度
        System.out.println("3，返回 E，方法：get(int index)");
        System.out.println("4，返回 int，方法：size()");
        System.out.println("myStrArrList.size() = " + myStrArrList.size());
        for (int i = 0; i < myStrArrList.size(); i++) {
            System.out.print(myStrArrList.get(i) + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println("5, 返回boolean  方法 addAll(Collection<? extends E> c)");
        //5, 返回boolean  方法 addAll(Collection<? extends E> c)
        //按指定集合的Iterator返回的顺序将指定集合中的所有元素追加到此列表的末尾。
        System.out.println("添加 " + myStrArrList.addAll(myTwoStrArrList));
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println("6, 返回boolean、 方法 addAll(int index, Collection<? extends E> c)");
        //6, 返回boolean、 方法 addAll(int index, Collection<? extends E> c)
        //将指定集合中的所有元素插入到此列表中，从指定的位置开始。
        System.out.println("添加 " + myStrArrList.addAll(0, myTwoStrArrList));
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println("7, 返回 Object、 方法 clone()");
        System.out.println("返回此 ArrayList实例的浅拷贝。浅拷贝就是 你改变我也改变，");
        System.out.println(" 只对Object生效 ");
        //  7, 返回 Object、 方法 clone()
        //返回此 ArrayList实例的浅拷贝。
        //myTwoStrArrList = myStrArrList.clone()
        //myObjArrList = myStrArrList.clone();
        Object[] myObjTwoArr = new Object[myStrArrList.size()];
        myObjTwoArr[0] = myStrArrList.clone();

        System.out.print("myStrArrList = ");
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("myObjTwoArr[0] = " + myObjTwoArr[0]);
        System.out.println("修改 myObjTwoArr[0] ");
        myObjTwoArr[0] = myTwoStrArrList.clone();
        System.out.println("myObjTwoArr[0] = " + myObjTwoArr[0]);
        System.out.print("myStrArrList = ");
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println(" 8, 返回 boolean、 方法 contains(Object o) ");
        System.out.println(" 如果此列表包含指定的元素，则返回 true 。");
        // 8, 返回 boolean、 方法 contains(Object o)
        // 如果此列表包含指定的元素，则返回 true 。
        System.out.println(myStrArrList.contains("1000"));
        System.out.println(myStrArrList.contains("100"));
        System.out.println(" 9, 返回 boolean、 方法 containsAll(Object o) ");
        System.out.println(" 如果此列表包含指定的元素，则返回 true 。");
        // 9, 返回 boolean、 方法 contains(Object o)
        // 如果此列表包含指定的元素，则返回 true 。
        System.out.println(myStrArrList.containsAll(myTwoStrArrList));
        System.out.println(myStrArrList.containsAll(myIntArrList));
        System.out.println("=====================================");

        System.out.println(" 10, 返回 void、 方法 ensureCapacity(int minCapacity)  ");
        System.out.println(" 如果需要，增加此 ArrayList实例的容量，以确保它可以至少保存最小容量参数指定的元素数。");
        // 10, 返回 void、 方法 ensureCapacity(int minCapacity)
        // 如果需要，增加此 ArrayList实例的容量，以确保它可以至少保存最小容量参数指定的元素数。
        System.out.println("=====================================");

        System.out.println(" 11, 返回 void、 方法 forEach(Consumer<? super E> action)   ");
        System.out.println(" 对 Iterable的每个元素执行给定的操作，直到所有元素都被处理或动作引发异常。 ");
        // 10, 返回 void、 方法 forEach(Consumer<? super E> action)
        // 对 Iterable的每个元素执行给定的操作，直到所有元素都被处理或动作引发异常。
        //for(Integer i : list) {
        //    System.out.println(i);
        //}
        // java1.8 ---  list.forEach(x -> System.out.print(x));
        System.out.println("=====================================");

        System.out.println(" 12, 返回int、 方法 indexOf(Object o)    ");
        System.out.println(" 返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。  ");
        // 11, 返回int、 方法 indexOf(Object o)
        // 返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
        System.out.println(myStrArrList.indexOf(1111));
        System.out.println(myStrArrList.indexOf("1111"));
        System.out.println("=====================================");

        System.out.println(" 13, 返回 boolean 方法 isEmpty()     ");
        System.out.println(" 如果此列表不包含元素，则返回 true 。   ");
        // 13, 返回 boolean 方法 isEmpty()
        // 如果此列表不包含元素，则返回 true 。
        System.out.println(myStrArrList.isEmpty());
        System.out.println("=====================================");

        System.out.println(" 14, 返回 Iterator<E> 方法 iterator()      ");
        System.out.println(" 以正确的顺序返回该列表中的元素的迭代器。    ");
        // 14, 返回 Iterator<E> 方法 iterator()
        // 以正确的顺序返回该列表中的元素的迭代器。
        Iterator<String> temp = myStrArrList.iterator();
        while (temp.hasNext()) {
            System.out.print(temp.next() + " ");
        }
        System.out.println();
        System.out.println("------------");
        for (Iterator<String> tempTwo = myStrArrList.iterator(); tempTwo.hasNext(); ) {
            System.out.print(tempTwo.next() + " ");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println(" 15, 返回 int 方法 lastIndexOf(Object o)  ");
        System.out.println(" 返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1。  ");
        // 15, 返回 int 方法 lastIndexOf(Object o)
        // 返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1。
        System.out.println(myStrArrList.lastIndexOf("1111"));
        System.out.println(myStrArrList.lastIndexOf(1111));
        System.out.println("=====================================");

        System.out.println(" 16, 返回 ListIterator<E> 方法 listIterator()  ");
        System.out.println(" 返回列表中的列表迭代器（按适当的顺序）。 ");
        System.out.println(" 17, 返回 ListIterator<E> 方法 listIterator(int index)   ");
        System.out.println(" 从列表中的指定位置开始，返回列表中的元素（按正确顺序）的列表迭代器。 ");
        // 16, 返回 ListIterator<E> 方法 listIterator()
        // 返回列表中的列表迭代器（按适当的顺序）。
        // 17, 返回 ListIterator<E> 方法 listIterator(int index)
        // 返回 ListIterator<E> 方法 listIterator(int index)
        System.out.println("=====================================");

        System.out.println(" 18, 返回 E 方法 remove(int index)  ");
        System.out.println(" 删除该列表中指定位置的元素。 ");
        System.out.println(" 19, 返回 boolean 方法 remove(Object o)   ");
        System.out.println(" 从列表中删除指定元素的第一个出现（如果存在）。  ");
        // 18, 返回 E 方法 remove(int index)
        // 删除该列表中指定位置的元素。
        // 19, 返回 boolean 方法 remove(Object o)
        // 从列表中删除指定元素的第一个出现（如果存在）。
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println(myStrArrList.remove("1111"));
        System.out.println(myStrArrList.remove("11"));
        //remove(int index) 会返回 E
        System.out.println(myStrArrList.remove(1));
        myStrArrList.remove(1);
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println(" 20, 返回 boolean  方法 removeAll(Collection<?> c)  ");
        System.out.println(" 从此列表中删除指定集合中包含的所有元素。");
        // 20, 返回 boolean  方法 removeAll(Collection<?> c)
        // 从此列表中删除指定集合中包含的所有元素。
        myStrArrList.removeAll(myTwoStrArrList);
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        myStrArrList.add("1111");
        myStrArrList.add("1111");
        myStrArrList.add("1111");
        myStrArrList.add("1111");
        myStrArrList.add("1777");
        myStrArrList.add("1112");
        myStrArrList.add("1000");
        System.out.println("=====================================");

        System.out.println(" 21, 返回 boolean  方法 removeIf(Predicate<? super E> filter)  ");
        System.out.println(" 删除满足给定谓词的此集合的所有元素。 ");
        // 21, 返回 boolean  方法 removeIf(Predicate<? super E> filter)
        // 删除满足给定谓词的此集合的所有元素。
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        myStrArrList.removeIf(String -> (!(String.equals("1111"))));
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println(" 1.8 版本没有此方法 ");
        System.out.println(" 22, 返回 protected void  方法 removeRange(int fromIndex, int toIndex)  ");
        System.out.println(" 从这个列表中删除所有索引在 fromIndex （含）和 toIndex之间的元素。 ");
        // 22, 返回 protected void  方法 removeRange(int fromIndex, int toIndex)
        // 从这个列表中删除所有索引在 fromIndex （含）和 toIndex之间的元素。
        //myStrArrList.removeRange
        System.out.println(" 1.8 版本没有此方法 ");
        System.out.println("=====================================");

        System.out.println(" 23, 返回 E  方法 set(int index, E element)  ");
        System.out.println(" 用指定的元素替换此列表中指定位置的元素。 ");
        // 23, 返回 E  方法 set(int index, E element)
        // 用指定的元素替换此列表中指定位置的元素。
        System.out.println(myStrArrList.set(1, "1000"));
        System.out.println(myStrArrList.set(3, "1100"));
        for (String s : myStrArrList) {
            System.out.print(s + ",");
        }
        System.out.println();

        myIntArrList.add(1100);
        myIntArrList.add(1110);
        myIntArrList.add(1000);
        myIntArrList.add(1112);
        for (int ss : myIntArrList) {
            System.out.print(ss + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println(" 24, 返回 void  方法 sort(Comparator<? super E> c)  ");
        System.out.println(" 使用提供的 Comparator对此列表进行排序以比较元素。 ");
        // 24, 返回 void  方法 sort(Comparator<? super E> c)
        // 使用提供的 Comparator对此列表进行排序以比较元素。
        // 没有实现sort方法
        System.out.println("=====================================");

        System.out.println(" 25, 返回 List<E>  方法 subList(int fromIndex, int toIndex)  ");
        System.out.println(" 返回此列表中指定的 fromIndex （包括）和 toIndex之间的独占视图。 ");
        // 26, 返回 List<E>  方法 subList(int fromIndex, int toIndex)
        // 返回此列表中指定的 fromIndex （包括）和 toIndex之间的独占视图。
        // 以下会报错
        // myTwoStrArrList = myStrArrList.subList(1,5);

        List<String> myStrList = new ArrayList<>();
        myStrList = myStrArrList.subList(1, 5);
        for (String s : myStrList) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("=====================================");

        System.out.println(" 26, 返回 Object[]  方法 toArray()  ");
        System.out.println(" 以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组。");
        // 26, 返回 Object[]  方法 toArray()
        // 以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组。
        //myTwoStrArrList = myStrArrList.toArray()
        //myObjArrList = myStrArrList.toArray();

        Object[] myObjArr = new Object[myStrArrList.size()];
        myObjArr = myStrArrList.toArray();
        for (int i = 0; i < myObjArr.length; i++) {
            System.out.print(myObjArr[i] + " ");
        }
        System.out.println();
        // https://www.cnblogs.com/ihou/archive/2012/05/10/2494578.html
        //
        System.out.println("=====================================");

        System.out.println(" 27, 返回 <T> T[]   方法 toArray(T[] a) ");
        System.out.println(" 以正确的顺序返回一个包含此列表中所有元素的数组（从第一个到最后一个元素）; " +
                "返回的数组的运行时类型是指定数组的运行时类型。 ");
        // 27, 返回 <T> T[]   方法 toArray(T[] a)
        //
        strNum = myStrArrList.toArray(strNum);
        for (int i = 0; i < strNum.length; i++) {
            System.out.print(strNum[i] + " ");
        }
        System.out.println();
        System.out.println("=====================================");


        System.out.println(" 28, 返回 void 方法 trimToSize()  ");
        System.out.println(" 修改这个 ArrayList实例的容量是列表的当前大小。 ");
        // 28, 返回 void 方法 trimToSize()
        // 修改这个 ArrayList实例的容量是列表的当前大小。
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        System.out.println("arrayList.size() = " + arrayList.size());
        arrayList.ensureCapacity(10);
        System.out.println("arrayList.size() = " + arrayList.size());
        arrayList.trimToSize();
        System.out.println("arrayList.size() = " + arrayList.size());
        System.out.println("以上三条没有任何变化");
        System.out.println("=====================================");

        System.out.println(" 29, 返回 void 方法 replaceAll(UnaryOperator<E> operator)   ");
        System.out.println(" 将该列表的每个元素替换为将该运算符应用于该元素的结果。  ");
        // 29, 返回 void 方法 replaceAll(UnaryOperator<E> operator)
        // 将该列表的每个元素替换为将该运算符应用于该元素的结果。
        for (String ss : myStrArrList) {
            System.out.print(ss + ",");
        }
        System.out.println();
        myStrArrList.replaceAll(a -> a + 1);
        for (String ss : myStrArrList) {
            System.out.print(ss + ",");
        }
        System.out.println();

        myTwoStrArrList.add("11111");
        System.out.println("=====================================");

        System.out.println(" 30, 返回 boolean  方法 retainAll(Collection<?> c) ");
        System.out.println(" 仅保留此列表中包含在指定集合中的元素。  ");
        // 30, 返回 boolean  方法 retainAll(Collection<?> c)
        // 仅保留此列表中包含在指定集合中的元素。
        System.out.println("myStrArrList.retainAll(myTwoStrArrList) = " + myStrArrList.retainAll(myTwoStrArrList));
        for (String ss : myStrArrList) {
            System.out.print(ss + ",");
        }
        System.out.println();

        myTwoStrArrList.clear();
        myTwoStrArrList.add("1");
        for (String ss : myTwoStrArrList) {
            System.out.print(ss + ",");
        }
        System.out.println();

        System.out.println("myStrArrList.retainAll(myTwoStrArrList) = " + myStrArrList.retainAll(myTwoStrArrList));
        for (String ss : myStrArrList) {
            System.out.print(ss + ",");
        }
        System.out.println();
        System.out.println("=====================================");
    }

}
