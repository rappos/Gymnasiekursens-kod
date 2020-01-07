package övning75;

import java.util.Scanner;

public class Övning75 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hur långt hoppade du? ");
        double längd = input.nextDouble();
        System.out.print("Vad var vindstyrkan? ");
        double vind = input.nextDouble();

        if (längd > 7.92 && vind <= 2.0) {
            System.out.println("Grattis!");
        } else if (längd == 7.92 && vind <= 2.0) {
            System.out.println("Du tangerade rekordet");
        } else {
            if (längd < 7.92) {
                System.out.println("Du hoppade för kort");
            }
            if (vind > 2.0) {
                System.out.println("Vinden var för stark");
            }
        }

    }

}
