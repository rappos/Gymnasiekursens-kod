package uppgift97;

import java.util.Scanner;

public class Uppgift97 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tal = input.nextInt();
        boolean svar = ärPrimtal(tal);
        System.out.println(svar);

    }

    static boolean ärPrimtal(int tal) {
        boolean svar = true;
        for (double i = 2; i < tal; i++) {
            if (tal % i == 0) {
                svar = false;
                break;
            }

        }

        return svar;
    }

}
