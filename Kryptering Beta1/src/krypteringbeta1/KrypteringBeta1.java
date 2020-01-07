package krypteringbeta1;

import java.util.Scanner;

public class KrypteringBeta1 {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char tecken;
        int i = 0;

        System.out.println("Detta program krypterar eller dekrypterar meningar du skriver in");
        System.out.println("Använd inte \"å,ä,ö\". Snälla");
        System.out.println("Vill du kryptera (K), eller dekryptera (D)?");
        System.out.print("K/D: ");
        String svara = input.next();
        String svar = svara.toUpperCase();

        if (svar.equals("K")) {
            System.out.println("Du valde kryptering");
            System.out.println("Separera ord i krypteringen med understreck");
            System.out.print("Kryptera: ");
            String mening = input.next();
           
            int längd = mening.length();

            while (i < längd) {
                tecken = mening.charAt(0 + i);
                char banan = (char) (tecken - (i+1));
                System.out.print(banan);
                i++;
            }
            System.out.println("");
            System.out.println("Klar!");
        }

        if (svar.equals("D")) {
            System.out.println("Du valde dekryptering");
            System.out.print("Dekryptera: ");
            String mening = input.next();
           
            int längd = mening.length();

            while (i < längd) {
                tecken = mening.charAt(0 + i);
                char banan = (char) (tecken + (i+1));
                System.out.print(banan);
                i++;
            }
            System.out.println("");
            System.out.println("Klar!");

        } 
        if(!svar.equals("D") && !svar.equals("K")) {
            System.out.println("Nej men sluta förstöra mitt program, försök att skriva in ett riktigt svar");
        }

    }

}

