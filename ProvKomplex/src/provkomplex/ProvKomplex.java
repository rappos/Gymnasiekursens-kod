package provkomplex;

import java.util.Scanner;

public class ProvKomplex {
    /*Programmet ber om ett fritt antal personers lösenord och namn, lagrar i arrayer 
     för att sedan göra samma kontroll som i de tidigare uppgifterna  */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hur många användare ska köra programmet?");
        System.out.print("Antal: ");
        int antalPersoner = input.nextInt();
        /*denna variabel används för att göra arrayerna, 
         *   antal varv i slingorna, och prints där antalet personer används
         */

        //Längden på dessa arrayer   är lika långa som   antalet användare
        String[] namn = new String[antalPersoner];                //array för namnen                                        
        String[] lösen = new String[antalPersoner];                 //array för lösenorden                                  
        String[] lösenKontroll = new String[antalPersoner];    //array för kontrollen                                

        System.out.println("Vi kommer be om " + antalPersoner + " personers namn och era lösenord");

        int i = 0; //variabeln för slingornas start deklareras

        while (i < antalPersoner) {
            System.out.print("Namnet på person nummer " + (i + 1) + ": ");
            namn[i] = input.next();
            System.out.print("Lösenordet till person nummer " + (i + 1) + ": ");
            lösen[i] = input.next();
            System.out.print("Bekräfta lösenordet till person nummer " + (i + 1) + ": ");
            lösenKontroll[i] = input.next();
            i++;
        }

        i = 0; // får värde 0 igen då den ökade i förra slingan 
        int längd; //variabeln för lösenordets längd
        while (i < antalPersoner) {
            längd = lösen[i].length(); //Längden av lösen defineras om för varje körning
            System.out.print("Användare " + namn[i] + ": ");

            if (lösen[i].equals(lösenKontroll[i]) && längd > 5) {      //Kollar om båda lösen är samma och om de är längre än 5
                System.out.print("Godkänt lösenord!");
            } else {
                System.out.print("Felaktigt lösenord!");
            }
            System.out.println(""); //ger avstånd i outputen mellan personerna 
            i++;
        }
        System.out.println("Klar! ");

    }

}
