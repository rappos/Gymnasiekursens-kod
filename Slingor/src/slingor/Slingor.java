/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slingor;

import java.util.Scanner;

/**
 *
 * @author aa92284
 */
public class Slingor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int varv = 0; //antal varv i loopen under
        int max;
        System.out.println("Hur många varv vill du ha?");
        Scanner snurr = new Scanner(System.in);
        max = snurr.nextInt();
        while (varv < max) {
            System.out.print("Hej! Detta är nummer ");
            System.out.println(varv + 1);
            ++varv; // ökar varv med 1
        }
        System.out.println("Klart! Hoppas du var nöjd med dina hej");
    }
}
