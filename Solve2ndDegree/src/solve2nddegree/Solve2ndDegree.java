package solve2nddegree;

import java.util.Scanner;

public class Solve2ndDegree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv in andragradaren i formatet ax^2+bx+c");
        System.out.print("a: ");
        double a = input.nextDouble();
        System.out.print("b: ");
        double b = input.nextDouble();
        System.out.print("c: ");
        double c = input.nextDouble();

        solveZero(a, b, c);
        maxOrMin(a, b, c);
        derivata(a, b);
    }

    public static void solveZero(double a, double b, double c) {
        double svar1 = (((-b) / (2 * a)) + (Math.sqrt((Math.pow(b, 2) / Math.pow(2 * a, 2)) - (c / a))));
        double svar2 = (((-b) / (2 * a)) - (Math.sqrt((Math.pow(b, 2) / Math.pow(2 * a, 2)) - (c / a))));
        System.out.println("Nollställen");
        System.out.println("x1=" + svar1);
        System.out.println("x2=" + svar2);
        System.out.println();
    }

    public static void maxOrMin(double a, double b, double c) {
        double svar1 = (((-b) / (2 * a)) + (Math.sqrt((Math.pow(b, 2) / Math.pow(2 * a, 2)) - (c / a))));
        double svar2 = (((-b) / (2 * a)) - (Math.sqrt((Math.pow(b, 2) / Math.pow(2 * a, 2)) - (c / a))));

        double mitten = ((svar2 - svar1) / 2) + svar1;
        System.out.println("Symmetrilinje i x=" + mitten);
        System.out.println();

        double maxMin = (a * Math.pow(mitten, 2) + b * mitten + c);

        if (a == Math.abs(a)) {
            System.out.println("Minsta värde är " + maxMin);
        } else {
            System.out.println("Största värde är " + maxMin);
        }
        System.out.println();
    }

    public static void derivata(double a, double b) {
        System.out.println("Derivata");
        System.out.print("y=");

        System.out.print(2 * a + "x");
        if (b != 0.0) {
            if (b < 0) {
                System.out.print("-" + Math.abs(b));
            } else {
                System.out.println("+" + b);
            }

        }

    }

}
