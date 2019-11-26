package com.byit.model;

public class StringBuilderDemo {
    public static void main(String[] args) {
//        appendDemo();
        setReverse();
    }


    public static void constructor() {
        //  构造函数
        //  空构造，新建string
        StringBuilder stringBuilderOne = new StringBuilder();
        int capacityOne = 10;
        //  capacityOne 是StringBuilder的长度
        StringBuilder stringBuilderTwo = new StringBuilder(capacityOne);
        //  以string作为StringBuilder的首个元素
        String strOne = "abcdef";
        StringBuilder stringBuilderThree = new StringBuilder(strOne);
    }

    public static void appendDemo() {
        StringBuilder strBuilderOne = new StringBuilder();
        StringBuilder strBuilderTwo = new StringBuilder();

        System.out.println(" 返回 void     方法 append(boolean b) ");
        System.out.println(" 将boolean参数的字符串表示附加到序列中。 ");
        //  返回 void     方法 append(boolean b)
        //  将boolean参数的字符串表示附加到序列中。

        strBuilderOne.append(1);
        System.out.println("strBuilderOne = " + strBuilderOne);

        strBuilderOne.append('a');
        System.out.println("strBuilderOne = " + strBuilderOne);

        char[] charOne = new char[]{'b', 'c'};
        strBuilderOne.append(charOne);
        System.out.println("strBuilderOne = " + strBuilderOne);

        String strOne = "dfgh";
        strBuilderOne.append(strOne);
        System.out.println("strBuilderOne = " + strBuilderOne);

        char[] charTwo = new char[]{'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        strBuilderOne.append(charTwo, 2, 4);
        System.out.println("strBuilderOne = " + strBuilderOne);
        System.out.println("strBuilderOne = " + strBuilderOne);
        System.out.println("strBuilderTwo = " + strBuilderTwo);

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 int     方法 capacity()  ");
        System.out.println(" 返回当前容量。  ");
        //  返回 int     方法 capacity()
        //  返回当前容量。
        int capacityInt = strBuilderOne.capacity();
        System.out.println("capacityInt = " + capacityInt);


        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 char     方法 charAt(int index)   ");
        System.out.println(" 返回 char在指定索引在这个序列值。   ");
        //  返回 char     方法 charAt(int index)
        //  返回 char在指定索引在这个序列值。
        char charThree = strBuilderOne.charAt(2);
        System.out.println("charThree = " + charThree);


        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 StringBuilder     方法 deleteCharAt(int index)    ");
        System.out.println(" 删除 char在这个序列中的指定位置。   ");
        //  返回 StringBuilder     方法 deleteCharAt(int index)
        //  删除 char在这个序列中的指定位置。

        strBuilderOne = strBuilderOne.deleteCharAt(0);
        System.out.println("strBuilderTwo = " + strBuilderOne);


        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 StringBuilder     方法 delete(int start, int end)    ");
        System.out.println(" 删除此序列的子字符串中的字符   ");
        //  返回 StringBuilder     方法 delete(int start, int end)
        //  删除此序列的子字符串中的字符
        // cd
        strBuilderOne = strBuilderOne.delete(0, 4);
        System.out.println("strBuilderTwo = " + strBuilderOne);

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 int     方法 indexOf(String str)     ");
        System.out.println(" 返回指定子字符串第一次出现的字符串内的索引。   ");
        //  返回 int     方法 delete(int start, int end)
        //  删除此序列的子字符串中的字符

        System.out.println(" 返回 int     方法 indexOf(String str, int fromIndex)     ");
        System.out.println(" 返回指定子串的第一次出现的字符串中的索引，从指定的索引开始。    ");
        //  返回 int     方法 indexOf(String str, int fromIndex)
        //  返回指定子串的第一次出现的字符串中的索引，从指定的索引开始。

        System.out.println(" 返回 int     方法 lastIndexOf(String str)     ");
        System.out.println(" 返回指定子字符串最右边出现的字符串内的索引。     ");
        //  返回 int     方法 lastIndexOf(String str)
        //  返回指定子字符串最右边出现的字符串内的索引。

        System.out.println(" 返回 int     方法 length()      ");
        System.out.println(" 返回长度（字符数）。     ");
        //  返回 int     方法 length()
        //  返回长度（字符数）。

        System.out.println();
        System.out.println(" string中以及有实现，不再查看。 ");
        System.out.println();

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 StringBuilder     方法 insert(int offset, char c)     ");
        System.out.println(" 返回 StringBuilder     方法 insert(int offset, char[] str)     ");
        System.out.println(" 返回 StringBuilder     方法 insert(int index, char[] str, int offset, int len)   ");
        System.out.println(" 返回 StringBuilder     方法 insert(int offset, String str)    ");
        System.out.println(" 返回指定子字符串第一次出现的字符串内的索引。   ");
        //  返回 StringBuilder     方法 insert(int offset, char c)
        //  返回 StringBuilder     方法 insert(int offset, char[] str)
        //  返回 StringBuilder     方法 insert(int index, char[] str, int offset, int len)
        //  返回 StringBuilder     方法 insert(int offset, String str)
        //  返回指定子字符串第一次出现的字符串内的索引。
        char[] charFour = new char[]{'B', 'C', 'D'};

        strBuilderOne.insert(1, 'A');
        System.out.println("strBuilderOne = " + strBuilderOne);

        strBuilderOne.insert(1, charFour);
        System.out.println("strBuilderOne = " + strBuilderOne);

        strBuilderOne.insert(1, charFour, 1, 2);
        System.out.println("strBuilderOne = " + strBuilderOne);

        String strTwo = "ZYX";
        strBuilderOne.insert(1, strTwo);
        System.out.println("strBuilderOne = " + strBuilderOne);

        strBuilderTwo.append(strTwo);
        System.out.println("strBuilderTwo = " + strBuilderTwo);
    }

    public static void setReverse() {
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 int     方法 length()     ");
        System.out.println(" 返回长度（字符数）。     ");
        //  返回 int     方法 length()
        //  返回长度（字符数）。
        StringBuilder strBuilderOne = new StringBuilder();
        strBuilderOne.append("abcdef");
        int length = strBuilderOne.length();
        System.out.println("strBuilderOne length = " + length);

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 StringBuilder     方法 reverse()     ");
        System.out.println(" 导致该字符序列被序列的相反代替。    ");
        //  返回 StringBuilder     方法 reverse()
        //  导致该字符序列被序列的相反代替。
        strBuilderOne.reverse();
        System.out.println("strBuilderOne  = " + strBuilderOne);
        strBuilderOne.reverse();

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 StringBuilder     方法 replace(int start, int end, String str)     ");
        System.out.println(" 用指定的String中的字符替换此序列的子字符串中的 String 。     ");
        //  返回 StringBuilder     方法 replace(int start, int end, String str)
        //  用指定的String中的字符替换此序列的子字符串中的 String 。
        String strOne = "ABCD";
        strBuilderOne.replace(0, 4, strOne);
        System.out.println("strBuilderOne  = " + strBuilderOne);

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 void     方法 setCharAt(int index, char ch)      ");
        System.out.println(" 指定索引处的字符设置为 ch 。      ");
        //  返回 void     方法 setCharAt(int index, char ch)
        //  指定索引处的字符设置为 ch 。
        strBuilderOne.setCharAt(0, 'B');
        System.out.println("strBuilderOne = " + strBuilderOne);

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 void     方法 setLength(int newLength)      ");
        System.out.println(" 设置字符序列的长度。     ");
        //  返回 void     方法 setLength(int newLength)
        //  设置字符序列的长度。
        length = strBuilderOne.length();
        System.out.println("strBuilderOne length = " + length);
        strBuilderOne.setLength(20);
        System.out.println("strBuilderOne length = " + strBuilderOne.length());

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(" 返回 String     方法 substring(int start)       ");
        System.out.println(" 返回 String     方法 substring(int start, int end)        ");
        System.out.println(" 设置字符序列的长度。     ");
        //  返回 void     方法 setLength(int newLength)
        //  设置字符序列的长度。
        String subStrOne = strBuilderOne.substring(3);
        String subStrTwo = strBuilderOne.substring(1, 3);
        System.out.println(" subStrOne " + subStrOne);
        System.out.println(" subStrTwo " + subStrTwo);

        strBuilderOne.trimToSize();
        System.out.println("strBuilderOne = " + strBuilderOne);
        System.out.println(strBuilderOne.length());
    }
}
