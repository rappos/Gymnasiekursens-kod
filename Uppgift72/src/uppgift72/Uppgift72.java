package uppgift72;

import java.util.Scanner;

public class Uppgift72 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Är du ensamstående eller sammanboende?");
        System.out.print("Civilstatus: ");
        String boende = input.next();
        System.out.println("Hur långt har du till jobbet?");
        System.out.print("Km till jobbet: ");
        double långt = input.nextDouble();
        System.out.println("Hur långt varar arbetet?");
        System.out.print("Tid i antal år: ");
        double år = input.nextDouble();

        if (långt >= 50) {
            if (boende.equalsIgnoreCase("sammanboende")) {
                if (år < 3) {
                    System.out.println("Du får avdrag!");
                } else {
                    System.out.println("Tyvärr, det är för lång tid");
                }
            } else if (boende.equalsIgnoreCase("ensamstående")) {
                if (år < 1) {
                    System.out.println("Du får avdrag");
                } else {
                    System.out.println("Tyvärr, det är för lång tid");
                }
            }
        } else {
            System.out.println("Tyvärr, du bor för nära.");
        }
    }

}
