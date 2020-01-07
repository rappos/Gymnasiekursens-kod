package övning76;

import java.util.Scanner;

public class Övning76 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Hej och välkommen");
            System.out.println("Hur många skivor har du? ");
            System.out.print("Antal: ");
            double antalSkivor = input.nextDouble();
            double pris;
            double rabatt;

            if (antalSkivor >= 10) {
                rabatt = 0.95;
            } else if (antalSkivor >= 50) {
                rabatt = 0.90;
            } else if (antalSkivor >= 100) {
                rabatt = 0.85;
            } else {
                rabatt = 1.0;
            }

            pris = antalSkivor * 9.90 * rabatt;

            System.out.println("Du behöver betala " + pris + " kr");
            System.out.println("Tack för ditt köp. Ha en fortsatt bra dag!");
            System.out.println("");
        }

    }

}
