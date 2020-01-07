package uppgift94;

import java.util.Scanner;

public class Uppgift94 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double tal = input.nextDouble();
        tecken(tal);

    }

    private static void tecken(double tal) {
        if (tal > (tal * -1)) {
            System.out.println("Det är positivt");
        } else {
            System.out.println("Det är negativt");
        }
    }

}
