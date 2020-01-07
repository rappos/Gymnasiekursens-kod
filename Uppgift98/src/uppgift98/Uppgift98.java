package uppgift98;

import java.util.Scanner;

public class Uppgift98 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bas: ");
        Double bas = input.nextDouble();
        System.out.print("Exponent: ");
        Double exponent = input.nextDouble();

        double potens = potens(bas, exponent);
        System.out.println(potens);
    }

    private static double potens(Double bas, Double exponent) {
        double potens = 1;
        if (exponent == 0) {
            potens = 1;
        } else if (exponent == 1) {
            potens = bas;
        } else {
            for (int i = 1; i <= exponent; i++) {
                potens = potens * bas;
            }

        }

        return potens;
    }

}
