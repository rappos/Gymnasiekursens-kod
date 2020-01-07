package övning91;

import java.util.Scanner;

public class Övning91 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Radie: ");
        int radie = input.nextInt();
        double svar = basytaCylinder(radie);
        System.out.println(svar);

    }

    static double basytaCylinder(double radie) {
        double area = (radie * radie * 3.14);

        return area;
    }
}
