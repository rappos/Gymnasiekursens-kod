package övning77;

import java.util.Scanner;

public class Övning77 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int konto = 1000;
        int ut;
        int ins;
        while (true) {
            System.out.println("");
            System.out.println("MENY");
            System.out.println("1. Insättning");
            System.out.println("2. Uttag");
            System.out.println("3. Visa behållning");
            System.out.println("");
            System.out.print("Val: ");
            int svar = input.nextInt();

            switch (svar) {

                case 1:
                    System.out.println("Hur mycket vill du sätta in?");
                    System.out.print("Kr: ");
                    ins = input.nextInt();
                    konto += ins;
                    break;

                case 2:
                    System.out.println("Hur mycket vill du ta ut?");
                    System.out.print("Kr: ");
                    ut = input.nextInt();
                    if (ut > konto) {
                        System.out.println("Du kan inte ta ut mer än du har!");
                    } else {
                        konto -= ut;
                    }
                    break;

                case 3:
                    System.out.println("Du har " + konto + " kr på kontot");
                    break;

                default:
                    System.out.println("Var god välj en av alternativen i menyn");
            }

        }

    }

}
