package uppgift95;

import java.util.Scanner;

public class Uppgift95 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char tecken = input.next().charAt(0);
        boolean svar = siffra(tecken);
        System.out.println(svar);
    }

    static boolean siffra(char tecken) {
        boolean svar = false;
        int test = (int) tecken;
        if (test >= 48 && test <= 57) {
            svar = true;
        }
        return svar;
    }

}
