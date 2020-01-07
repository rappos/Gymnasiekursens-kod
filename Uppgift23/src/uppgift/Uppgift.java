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
        
        System.out.println("Skriv ett substantiv: ");
        String sub = input.next();
        
        System.out.println("Skriv dess ändelse: ");
        String änd = input.next();
        
        sub = sub.toLowerCase();
        änd = änd.toLowerCase();
        
        System.out.println("En/Ett " + sub + ", flera " + (sub + (änd)));
    }
    
}
