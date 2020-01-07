/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.*;

/**
 *
 * @author aa92284
 */
public class Anagram {

    public static void main(String[] args) {
        String ord1;
        String ord2;
        Scanner input = new Scanner(System.in);
        System.out.print("Skriv ord nummer 1: ");
        ord1 = input.nextLine();
        System.out.print("Skriv ord nummer 2: ");
        ord2 = input.nextLine();
        System.out.println(Anagrams(ord1, ord2));
    }

    public static boolean Anagrams(String ord1, String ord2) {
        if (ord1.length() != ord2.length()) {   //kollar om de är lika långa
            return false;                       //ger fel om de inte är det
        }
        ord1 = ord1.toUpperCase();  //Gör till stora bokstäver
        ord2 = ord2.toUpperCase();  //Gör till stora bokstäver
        char[] ord1_chars = ord1.toCharArray(); //Lägger alla bokstäver på en rad
        Arrays.sort(ord1_chars);                //sorterar dem
        char[] ord2_chars = ord2.toCharArray(); //Lägger alla bokstäver på en rad
        Arrays.sort(ord2_chars);                //sorterar dem
        return Arrays.equals(ord1_chars, ord2_chars);
    }

}
