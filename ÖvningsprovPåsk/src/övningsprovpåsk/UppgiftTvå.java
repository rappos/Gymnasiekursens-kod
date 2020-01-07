package övningsprovpåsk;

import java.util.Scanner;

public class UppgiftTvå {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] tal = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Skriv ett heltal: ");
            tal[i] = input.nextInt();
        }
        bubbleSort(tal);
        for (int i = 0; i < 5; i++) {
            System.out.print(tal[i] + ", ");
        }
    }

    private static void bubbleSort(int[] tal) {
        for (int m = tal.length - 1; m > 0; m--) {
            for (int n = 0; n < m; n++) {
                if (tal[n] > tal[n + 1]) {
                    int temp = tal[n];
                    tal[n] = tal[n + 1];
                    tal[n + 1] = temp;
                }
            }
        }
    }

}
