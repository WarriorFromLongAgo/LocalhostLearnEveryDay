package com.day17_Date;

public class SystemDemo {
    public static void main(String[] args) {
        SystemD();
    }

    public static void SystemD() {
        int i = 1;
        long startTimeOne = System.nanoTime();
        long startTime = System.currentTimeMillis();
        while (true) {
            if (i == 10000000) {
                break;
            }
            i++;
        }
        // 都是直接立即结束当前的程序
        // System.exit(0);
        // 正常退出status为 0 时为正常退出程序，也就是结束当前正在运行中的java虚拟机。
        // System.exit(1);
        // status为 非0 的其他整数（包括负数，一般是1或者-1），表示非正常退出当前程序。
        //

        long endTime = System.currentTimeMillis();
        long endTimeTwo = System.nanoTime();

        long diff = endTime - startTime;
        long diffTwo = endTimeTwo - startTimeOne;
        System.out.println();
        System.out.println(diff);
        System.out.println(diffTwo);

        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] num2 = new int[num.length + 10];
        System.arraycopy(num, 1, num2, 2, num.length - 1);
        for (int jjj : num2) {
            System.out.print(i + ",");
        }
    }
}
