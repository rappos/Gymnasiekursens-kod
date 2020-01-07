package provenkel;

import java.util.Scanner;

public class ProvEnkel {

//Program som kollar längden på en input av lösenord, och godkänner om längre än 6 tecken
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vi ska undersöka om ditt lösenord är godkänt.");

        System.out.print("Skriv ditt lösenord: ");
        String lösen = input.next(); //lösenordet i variabeln lösen
        int längd = lösen.length(); //dess längd i variabeln längd

        //Detta sker om längden är mindre än 6        
        if (längd < 6) {
            System.out.println("Ditt lösenord var bara " + längd + " tecken långt.");
            System.out.println("Inte godkänt!");
        } //Annars sker detta
        else {
            System.out.println("Ditt lösenord var " + längd + " tecken långt och är därför godkänt.");
            System.out.println("Grattis!");
        }
        
        
        System.out.println("Programmet avslutas här");

    }

}
