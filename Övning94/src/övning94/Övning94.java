package övning94;

import java.util.Scanner;

public class Övning94 {

    static final double PI = 3.14159;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Mata in radien och höjden: ");
        double r = input.nextDouble();
        double h = input.nextDouble();
        double area = basareaCylinder(r);
        double volym = volymCylinder(r, h);
        System.out.println("Basarean är " + area);
        System.out.println("Volymen är " + volym);

    }

    static double basareaCylinder(double radie) {
        double area = PI * radie * radie;
        return area;
    }

    static double volymCylinder(double radie, double höjd) {
        double volym = PI * radie * radie * höjd;
        return volym;
    }

}
