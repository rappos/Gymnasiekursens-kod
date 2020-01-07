/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift25;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author aa92284
 */
public class Uppgift25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        System.out.println("Hejsan! Detta fina program kommer att runda av dina fina decimaler väldigt fint och snällt");
        System.out.println("Är du redo?");
        System.out.println("Nu kör vi");
        System.out.print("Skriv ditt tal: ");

        double tal = input.nextDouble();

        int heltal = (int) (tal + 0.5);
        System.out.println(heltal);
    }

}
