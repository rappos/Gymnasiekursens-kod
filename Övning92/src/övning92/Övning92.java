package övning92;

import java.util.Scanner;

public class Övning92 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ge två tal som är radie och höjd");
        System.out.print("Radie: ");
        double radie = input.nextDouble();
        System.out.print("Höjd: ");
        double höjd = input.nextDouble();

        System.out.println("Volymen är " + volymCylinder(radie, höjd));

    }

    static double volymCylinder(double radie, double höjd) {
        double volym = (radie * radie * höjd * 3.14);

        return volym;
    }

}
