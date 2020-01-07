/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package övning.pkg31;

import java.util.Scanner;
/**
 *
 * @author aa92284
 */
public class Övning31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        System.out.println("Vi ska göra en lista");
        
        int[] lista = new int[4];
        System.out.print("Tal 1: ");
        lista[0] = input.nextInt();
        System.out.print("Tal 2: ");
        lista[1] = input.nextInt();
        System.out.print("Tal 3: ");
        lista[2] = input.nextInt();
        System.out.print("Tal 4: ");
        lista[3] = input.nextInt();
        
        System.out.println("Här kommer din lista: ");
        System.out.print(lista[0] + "\t" + lista[1] + "\t" + lista[2] + "\t" + lista[3]);
        System.out.println("");
    }
    
}
