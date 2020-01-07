package programmeringsprov4;

import java.util.Scanner;

public class Uppgift3 {

    public static void main(String[] args) {

        int[] sortedArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};                                                 //Skapar två arrayer för testning av metoden 
        int[] notSortedArr = new int[]{324, 423, 52, 1, 45, 6, 31, 52, 62, 63, 63, 63};             //Döpta så här för tydlighetens skull i detta testprogram
        Scanner input = new Scanner(System.in);
        System.out.println("Hur långt in i arrayen vill du kolla? ");
        int n = input.nextInt();
        System.out.println("Är listan sortedArr sorterad till " + n + ": " + checkIfSorted(sortedArr, n));
        System.out.println("\nÄr listan notSortedArr sorterad till " + n + ": " + checkIfSorted(notSortedArr, n));
    }

    private static boolean checkIfSorted(int[] arr, int n) {
        if (n <= arr.length) {                                                         //Kör bara om vi kollar innanför arrayens längd
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {                                                //Returnerar false om ett tal är större än följande tal
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("Ditt värde på n var för högt!"); //Skrivs om n var för högt
            return false;
        }

    }

}
