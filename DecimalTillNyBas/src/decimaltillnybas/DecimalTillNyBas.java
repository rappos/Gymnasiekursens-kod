package decimaltillnybas;

import java.util.Scanner;

public class DecimalTillNyBas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vi ska omvandla tal till andra talsystem");
        String svarar = "Ja";
        while (svarar.equalsIgnoreCase("Ja")
                || svarar.equalsIgnoreCase("yes")
                || svarar.equalsIgnoreCase("japp")
                || svarar.equalsIgnoreCase("gärna")) {

            System.out.println("Vilket tal vill du omvandla?");
            System.out.print("Tal: ");
            int tal = input.nextInt();
            int talTillSvar = tal;

            System.out.println("Vilken bas vill du ha?");
            System.out.print("Bas: ");
            int bas = input.nextInt();

            if (bas < 2) {
                System.out.println("Nej men hur skulle en sån bas funka?");
            } else if (bas > tal) {
                System.out.print(talTillSvar + " blir med basen " + bas + ": " + talTillSvar);
                System.out.println("");
            } else {
                String lista = "";
                int mod;

                for (int j = 0; j < 1000; j++) {
                    mod = tal % bas;
                    lista = lista + mod;
                    tal = tal / bas;
                    if (tal >= 1) {
                        j = 998;
                    }

                }

                int längd = lista.length();
                System.out.print(talTillSvar + " blir med basen " + bas + ": ");

                for (int i = 0; i < (längd); i++) {

                    System.out.print(lista.charAt(((längd - 1) - i)));

                }
                System.out.println("");

            }
            System.out.println("Vill du köra igen??");
            System.out.print("Ja/Nej: ");
            svarar = input.next();
        }

    }
}
