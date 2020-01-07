package övning84;

import java.util.Scanner;

public class Övning84 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hur många tal vill du söka bland?");
        System.out.print("Tal: ");
        int antal = input.nextInt();

        int[] lista = new int[antal];

        //inputar
        for (int i = 0; i < antal; i++) {
            System.out.print("Tal " + (i + 1) + ": ");
            lista[i] = input.nextInt();
        }

        //störst
        int störst = 0;
        for (int i = 0; i < antal; i++) {
            if (i == 0) {
                störst = lista[i];
            } else {
                if (störst < lista[i]) {
                    störst = lista[i];
                }
            }
        }

        //minst
        int minst = 0;
        for (int i = 0; i < antal; i++) {
            if (i == 0) {
                minst = lista[i];
            } else {
                if (minst > lista[i]) {
                    minst = lista[i];
                }

            }
        }
        System.out.println("Minst: " + minst);
        System.out.println("Störst: " + störst);
    }

}
