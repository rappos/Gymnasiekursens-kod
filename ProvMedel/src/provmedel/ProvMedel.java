package provmedel;

import java.util.Scanner;

public class ProvMedel {
    /*Programmet ber om två personers lösenord och namn, lagrar i arrayer 
     för att sedan göra samma kontroll som i första uppgiften  */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] namn = new String[2];          //array för namnen
        String[] lösen = new String[2];           //array för lösenorden

        System.out.println("Vi kommer be om två personers namn och era lösenord");

        int i = 0; //variabeln för slingornas start deklareras

        while (i < 2) {
            System.out.print("Namnet på person nummer " + (i + 1) + ": ");
            namn[i] = input.next();
            System.out.print("Lösenordet till person nummer " + (i + 1) + ": ");
            lösen[i] = input.next();
            i++;
        }

        i = 0; // får värde 0 igen då den ökade i förra slingan 
        int längd; //variabeln för lösenordets längd
        while (i < 2) {
            längd = lösen[i].length(); //Längden av lösen defineras om för varje körning
            System.out.print("Användare " + namn[i] + ": ");
            if (längd < 6) {
                System.out.print("Ej godkänt lösenord");

            } else {
                System.out.print("Godkänt lösenord");
            }
            System.out.println(""); //ger avstånd i outputen mellan personerna 
            i++;
        }
        System.out.println("Klar! ");

    }

}
