package uppgift45;

import java.util.Scanner;

public class Uppgift45 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Mata in täljare och nämnare");
        System.out.print("Täljare: ");
        int täljare = input.nextInt();
        System.out.print("Nämnare: ");
        int nämnare = input.nextInt();
        int heldel = täljare / nämnare;
        int nyTäljare = täljare % nämnare;

        if (täljare < nämnare) {
            System.out.println("Redan klart. Går inte att göra nåt åt det med detta program");
        } 
        else if(täljare == nämnare){
            System.out.println("Talet i blandad form blir: 1");
        }
        
        else {
            System.out.println("Talet i blandad form blir: " + heldel + " " + nyTäljare + "/" + nämnare);
        }

    }

}
