package komplexövningsprov2;

import java.util.Scanner;

public class KomplexÖvningsprov2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Detta program ritar kurvan y = ax^2 + bx + c");
        System.out.println("Ritar bara i den övre vänstra hörnet");

        System.out.print("Ange a: ");
        double a = input.nextDouble();
        System.out.print("Ange b: ");
        double b = input.nextDouble();
        System.out.print("Ange c: ");
        double c = input.nextDouble();

        System.out.println("Här kommer grafen!");
        for (int i = 0; true; i++) {
            int y = (int) (a * Math.pow(i, 2) + i * b + c);
            if (y < 0) {
                break;
            }
            for (int j = 0; j < y; j++) {
                System.out.print("  ");
            }
            System.out.print("*");
            System.out.println();
        }
    }

}
