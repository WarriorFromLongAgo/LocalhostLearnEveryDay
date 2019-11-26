package com.day25_she_ji_mo_shi.singlecasedesign.multiplecases;

public class MultipleCases {
    public static void main(String[] args) {
        sex a = sex.getInstance(sex.Male_Cmd);
        System.out.println(a);
        sex b = sex.getInstance(sex.FeMale_Cmd);
        System.out.println(b);
    }

}

class sex {
    public static final int Male_Cmd = 1;
    public static final int FeMale_Cmd = 2;
    private static final sex Male = new sex("男");
    private static final sex Femael = new sex("女");

    private String title;

    private sex(String title) {
        this.title = title;
    }

    public static sex getInstance(int ch) {
        switch (ch) {
            case Male_Cmd:
                return Male;
            case FeMale_Cmd:
                return Femael;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "sex{" +
                "title='" + title + '\'' +
                '}';
    }
}
