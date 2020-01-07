package sortera;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sortera {

    static long antalFörsökBogus = 0;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int[] lista = new int[10];

        for (int i = 0; i < 10; i++) {
            lista[i] = rand.nextInt(100) + 1;
        }

        System.out.println("Innan: ");
        System.out.println(Arrays.toString(lista));
        System.out.println();

        System.out.println("Vilken sorteringsmetod?");
        System.out.println("1. Infogning");
        System.out.println("2. Bubbel");
        System.out.println("3. Bogus");
        System.out.println("4. Selektion");
        System.out.println("5. Merge");
        System.out.print("Svar: ");
        int svar = input.nextInt();
        System.out.println();

        switch (svar) {
            case 1:
                InfogaSortera(lista);
                System.out.println("Efter: ");
                System.out.println(Arrays.toString(lista));
                break;

            case 2:
                BubbelSortera(lista);
                System.out.println("Efter: ");
                System.out.println(Arrays.toString(lista));
                break;

            case 3:
                BogusSortera(lista);
                System.out.println("Antal försök: " + antalFörsökBogus);
                System.out.println("Efter: ");
                System.out.println(Arrays.toString(lista));
                break;

            case 4:
                SelectionSort(lista);
                System.out.println("Efter: ");
                System.out.println(Arrays.toString(lista));

            default:
                System.out.println("Hejdå!");
        }

    }
//Infoga

    private static void InfogaSortera(int[] lista) {
        int i, temp;

        for (int n = 1; n < lista.length; n++) {
            temp = lista[n];
            i = n - 1;
            while (i >= 0 && lista[i] > temp) {
                lista[i + 1] = lista[i];
                i--;
            }
            lista[i + 1] = temp;
        }
    }
//Bubbel

    private static void BubbelSortera(int[] lista) {
        for (int m = lista.length - 1; m > 0; m--) {
            for (int n = 0; n < m; n++) {
                if (lista[n] > lista[n + 1]) {
                    int temp = lista[n];
                    lista[n] = lista[n + 1];
                    lista[n + 1] = temp;
                }
            }
        }
    }

    //Bogus
    private static void BogusSortera(int[] lista) {
        boolean isArraySorted = isSorted(lista);

        while (isArraySorted == false) {
            randomizeArray(lista);
            isArraySorted = isSorted(lista);
            antalFörsökBogus++;
        }
    }

    //Selection Sort
    private static void SelectionSort(int[] lista) {
        int varv = 0;
        int temp;
        while (varv < lista.length) {
            for (int i = varv; i < lista.length; i++) {
                if (lista[varv] > lista[i]) {
                    temp = lista[i];
                    lista[i] = lista[varv];
                    lista[varv] = temp;
                }
            }
            varv++;
        }
    }

    public static boolean isSorted(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static void randomizeArray(int[] ar) {
        Random rand = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int min = 0;
            int max = ar.length;
            int index = rand.nextInt(max - min) + min;
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
