package övningsprovpåsk;

import java.util.Scanner;

public class UppgiftEtt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println("Hej! Ska vi kolla om ditt tal är en siffra?");
        System.out.print("Tal: ");
        char inmatat = input.next().charAt(0);

        if (isNumber(numbers, inmatat)) {
            System.out.println("Yes, " + inmatat + " var ett tal");
        } else {
            System.out.println("Nej, " + inmatat + " var inte ett tal");
        }
    }

    private static boolean isNumber(char[] c, char input) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == input) {
                return true;
            }
        }
        return false;
    }
}
