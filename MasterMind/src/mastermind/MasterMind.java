package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] färger = new String[]{"Red", "Green", "Yellow", "Blue", "Purple", "Orange", "Black", "White"};
        String[] rättSvar = new String[4];
        String[] gissning = new String[4];

        System.out.println("Let's play MasterMind\n");

        System.out.println("The colors (8) you can choose from are: ");
        System.out.println(Arrays.toString(färger));

        placeraSvarsfärgerna(färger, rättSvar);

        int end = 0;

        while (end < 10) {
            System.out.println("\nGuess the colors from right to left");
            for (int i = 0; i < 4; i++) {
                System.out.print((i + 1) + ": ");
                gissning[i] = input.next();
            }
            if (gissning[0].equalsIgnoreCase(rättSvar[0])
                    && gissning[1].equalsIgnoreCase(rättSvar[1])
                    && gissning[2].equalsIgnoreCase(rättSvar[2])
                    && gissning[3].equalsIgnoreCase(rättSvar[3])) {
                System.out.println("That's the one! You won!");
                System.exit(0);

            } else {
                countResponse(gissning, rättSvar);
                System.out.println((10 - end - 1) + " tries left");
                System.out.println();
                end++;
            }

        }

    }

    private static void placeraSvarsfärgerna(String[] färger, String[] rättSvar) {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int index = rand.nextInt(färger.length);
            rättSvar[i] = färger[index];
        }
    }

    private static void countResponse(String[] gissning, String[] rättSvar) {

        int rätt = 0;
        for (int i = 0; i < 4; i++) {
            if (gissning[i].equalsIgnoreCase(rättSvar[i])) {
                rätt++;
            }
        }

        int fel = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (gissning[j].equalsIgnoreCase(rättSvar[k])) {
                    fel++;
                }
            }
        }
        System.out.println(rätt + " in the right place");
        System.out.println((fel - rätt) + " in the wrong place");
    }

}
