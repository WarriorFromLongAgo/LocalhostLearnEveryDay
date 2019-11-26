package com.byit.model;

public class SIntGrammer {
    public static void main(String[] args) {
        DecimalToBinary decimalToBinary = new DecimalToBinary();
        decimalToBinary.decimalToBinary();
    }
}

class DecimalToBinary {
    /**
     *
     */
    public void decimalToBinary() {
        int n, b = 0, c = 0, d;
        n = 11;
        while (n != 0) {
            d = n % 2;
            b = b + d * (int) Math.pow(10, c++);
            n /= 2;
        } //converting decimal to binary
        System.out.println("\tBinary number: " + b);
    }
}
