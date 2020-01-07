package uppgift85;

import java.util.Scanner;

public class Uppgift85 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Vad är högsta talet?");
        int tal = input.nextInt();

        int i;
        int summa = 0;

        for (i = 0; i <= tal; i++) {
            summa = summa + i;
            System.out.println("");
        }

        System.out.println("Summa: " + summa);
    }

}
