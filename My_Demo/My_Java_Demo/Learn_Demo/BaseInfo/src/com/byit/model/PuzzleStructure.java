package com.byit.model;

class Puzzle4b {
    int ivar;

    public int DoStuff(int ff) {
        if (ivar > 100) {
            return ivar * ff;
        } else {
            return ivar * (5 - ff);
        }
    }
}

public class PuzzleStructure {
    public static void main(String[] args) {
        Puzzle4b[] obs = new Puzzle4b[6];
        int y = 1;
        int x = 0;
        int result = 0;
        while (x < 6) {
            obs[x] = new Puzzle4b();
            obs[x].ivar = y;
            y = y * 10;
            x = x + 1;
        }
        x = 6;
        while (x > 0) {
            x--;
            result = result + obs[x].DoStuff(x);
        }
        System.out.println(result);

    }
}
