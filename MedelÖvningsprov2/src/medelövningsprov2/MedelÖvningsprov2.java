package medelövningsprov2;

import java.util.Scanner;

public class MedelÖvningsprov2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int poäng = 0;

        System.out.print("Antal rader i ditt tips: ");
        int antal = input.nextInt();

        String[] lista = new String[antal];

        for (int i = 0; i < antal; i++) {
            System.out.print("Plats " + (i + 1) + ": ");
            lista[i] = input.next();
        }

        for (int i = 0; i < antal; i++) {
            if ((i + 1) % 3 == 0) {
                if (lista[i].equalsIgnoreCase("1")) {
                    System.out.println(lista[i] + " rätt");
                    poäng++;
                } else {
                    System.out.println(lista[i] + " fel");
                }
            }
            if ((i + 1) % 3 == 1) {
                if (lista[i].equalsIgnoreCase("x")) {
                    System.out.println(lista[i] + " rätt");
                    poäng++;
                } else {
                    System.out.println(lista[i] + " fel");
                }
            }
            if ((i + 1) % 3 == 2) {
                if (lista[i].equalsIgnoreCase("2")) {
                    System.out.println(lista[i] + " rätt");
                    poäng++;
                } else {
                    System.out.println(lista[i] + " fel");
                }
            }
        }
        System.out.println("Antal rätt: "+ poäng);
    }

}
