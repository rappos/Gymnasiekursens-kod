package övning97;

import java.util.Scanner;

public class Övning97 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println("Innan: " + text);
        System.out.print("Efter: ");
        text = vändText(text);
        System.out.println(text);

    }

    private static String vändText(String text) {

        int längd = text.length();
        char[] lista = new char[längd];

        for (int i = 0; i < längd; i++) {
            lista[(längd - 1 - i)] = text.charAt(i);
        }
        for (int i = 0; i < längd; i++) {
            System.out.print(lista[i]);
        }

        String svar = "";
        return svar;
    }

}
