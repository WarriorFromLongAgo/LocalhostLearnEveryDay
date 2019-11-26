package com.byit.model;

public class SwitchGrammar {
    public void switchGrammar() {
        int tempInt = 5;
        switch (tempInt){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wedensday");
                break;
            case 4:
                System.out.println("");
                break;
            default:
                System.out.println("dfsfsfssf");
                break;
        }

    }


    public static void main(String[] args) {
        SwitchGrammar ff = new SwitchGrammar();
        ff.switchGrammar();


    }
}
