package uppgift710;

import java.util.Scanner;

public class Uppgift710 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Vi ska söka efter ett visst ord i en text");
        System.out.println("Skriv in din text på nästa rad");
        System.out.print("Text: ");
        String texten = input.nextLine();
        System.out.print("Ordet du söker: ");
        String ord = input.next();
  
        if (texten.indexOf(ord) >= 0) {
            System.out.println("Ditt ord finns");
        } else {
            System.out.println("Ditt ord finns ej");
        }

    }

}
