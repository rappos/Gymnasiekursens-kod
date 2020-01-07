package störstatalet;

import java.util.Scanner;

public class StörstaTalet {

    public static void main(String[] args) {
        int[] lista = new int[5];
        Scanner input = new Scanner(System.in);

        int i = 0;

        System.out.println("Hur många tal har du?");
        System.out.print("Antal: ");
        int x = input.nextInt();

        System.out.println("Skriv " + x + " heltal");

        while (i < x) {
            System.out.print("Tal " + (i + 1 + ": "));
            lista[(0 + i)] = input.nextInt();
            i++;
        }
        int z = 0;
        for (i = 0; i < x; i++) {
            if (lista[i] > z) {
                z = lista[i];
            }
        }

        System.out.println("Det största talet är " + z);

    }
}
