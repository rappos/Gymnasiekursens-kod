package exempel09_08;

import java.util.Scanner;

public class Exempel09_08 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv den potens som ska beräknas " + "(bas och exponent): ");
        double bas = scan.nextDouble();
        double exponent = scan.nextDouble();

        double resultat = Math.pow(bas, exponent);
        System.out.println(bas + " ^ " + exponent + " = " + resultat);
    }

}
