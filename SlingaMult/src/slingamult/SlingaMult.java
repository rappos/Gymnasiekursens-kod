/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slingamult;

import java.util.Scanner;

/**
 *
 * @author aa92284
 */
public class SlingaMult {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x;
        int y;
        int varv = 1;

        System.out.println("Vilken multiplikationstabell vill du ha?");
        Scanner langd = new Scanner(System.in);
        x = langd.nextInt();

        System.out.println("Hur långt ska den gå?");
        Scanner hajd = new Scanner(System.in);
        y = hajd.nextInt();

        System.out.println("Nu kör vi upp till " + x + " gånger " + y);

        while (varv < y + 1) {
            System.out.println(x * varv);
            varv = varv + 1;
        }
        System.out.println("Klar!");
        
    }
}
