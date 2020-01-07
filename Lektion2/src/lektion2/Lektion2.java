/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lektion2;

import java.util.Scanner;

/**
 *
 * @author aa92284
 */
public class Lektion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String namn;
        System.out.println("Tjenare, vad heter en snygging som du då?");
        Scanner kalle = new Scanner(System.in);
        namn = kalle.next();

        if (namn.equals("Emil")) {
            System.out.println("Nämen, det heter jag också!");
        } else if (namn.equals("Smilla")) {
            System.out.println("Hej Smilla! Va kul att ses!");
        } else {
            System.out.println("Hej " + namn + "!");
        }

        int alder; //Personens ålder
        System.out.println("Hur gammal är du?");
        alder = kalle.nextInt();

        if (alder < 10) {
            System.out.println("Du är rätt ung");
        }

        if (alder == 18) {
            System.out.println("Du är just myndig");
        }

        System.out.println("Vilken månad är du född?");

        String manad;
        Scanner man = new Scanner(System.in);
        manad = man.nextLine();

        if (manad == "januari" || manad == "februari" || manad == "mars" || manad == "april" || manad == "maj" || manad == "juni" || manad == "juli" || manad == "augusti") {
            System.out.println("Du är född år " + (2017 - alder));
        }

        if (manad == "Januari" || manad == "Februari" || manad == "Mars" || manad == "April" || manad == "Maj" || manad == "Juni" || manad == "Juli" || manad == "Augusti") {
            System.out.println("Du är född år " + (2017 - alder));
        } else {
            System.out.println("Du är född år " + (2016 - alder));
        }

    }
}
