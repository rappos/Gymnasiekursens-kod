/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift;

import java.util.Scanner;

/**
 *
 * @author aa92284
 */
public class Uppgift {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Skriv triangelns bas: ");
        double bas = input.nextDouble();
        
        System.out.println("Skriv triangelns höjd: ");
        double höjd = input.nextDouble();

        double svar = (bas * höjd) / 2;
        System.out.println("Arean är: " + svar);

    }

}
