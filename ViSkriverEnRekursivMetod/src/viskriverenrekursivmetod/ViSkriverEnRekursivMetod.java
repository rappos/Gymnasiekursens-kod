package viskriverenrekursivmetod;

import java.util.Scanner;

public class ViSkriverEnRekursivMetod {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        printArray(arr, 8);

    }

    private static void printArray(int[] arr, int n) {
        if (n <= 0) {
            return; //Basfall
        }
        printArray(arr, n - 1); //Skickas vidare rekursivt
        System.out.print(arr[n - 1] + " ");

    }

}
