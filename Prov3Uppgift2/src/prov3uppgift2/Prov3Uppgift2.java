package prov3uppgift2;

import java.util.Scanner;

public class Prov3Uppgift2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int antalOrd = 3;                                                       //Variabel för antal ord, ändra bara här vid förändring av program
        String[] orden = new String[antalOrd];

        for (int i = 0; i < antalOrd; i++) {
            System.out.println("Skriv ett ord!");
            orden[i] = input.nextLine();
        }

        System.out.println("Dina ord var:");
        for (int i = 0; i < antalOrd; i++) {
            System.out.println((i + 1) + " " + orden[i]);          //i +1 eftersom arrayer börjar på 0 men vi räknar från 1 i listor
        }
    }

}
