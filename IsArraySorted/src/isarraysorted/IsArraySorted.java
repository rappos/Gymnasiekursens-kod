package isarraysorted;

import java.util.*;

public class IsArraySorted {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Hur lång ska arrayen vara? : ");
        int arrayLength = input.nextInt();

        int list[] = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int rand = (int) (Math.random() * 100 + 1);
            list[i] = rand;
        }

        boolean isArraySorted = isSorted(list);
        long antalFörsök = 0;
        while (isArraySorted == false) {
            randomizeArray(list);
            isArraySorted = isSorted(list);
            antalFörsök++;
        }

        for (int i = 0; i < arrayLength; i++) {
            System.out.println(list[i]);
        }

        System.out.println("Det tog " + antalFörsök + " försök att slumpa listan rätt");
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
