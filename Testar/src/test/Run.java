package test;

import java.math.BigInteger;

class Run {

    public static void main(String[] args) {
        BigInteger boi = new BigInteger("2");
        while (true) {
            boi = boi.multiply(boi);
            System.out.println(boi);
        }
    }
}
