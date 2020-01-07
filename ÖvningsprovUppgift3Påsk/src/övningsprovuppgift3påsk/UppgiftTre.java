package övningsprovuppgift3påsk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UppgiftTre {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] tal = new int[10];
        int i = 0;
        System.out.println("0 avbryter inmatningen");
        i = numberReader(i, tal, input);
        sort(tal, i);
    }

    private static int numberReader(int i, int[] tal, Scanner input) {
        while (i < 10) {
            try {
                System.out.print("Skriv ett heltal: ");
                tal[i] = input.nextInt();
                if (tal[i] == 0) {
                    break;
                }
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Skriv ett heltal!!!");
                input.next();
            }
        }
        return i;
    }

    private static void sort(int[] tal, int i) {
        for (int m = tal.length - 1; m > 0; m--) {
            for (int n = 0; n < m; n++) {
                if (tal[n] % 2 == 0 && tal[n + 1] % 2 != 0) {
                    int temp = tal[n];
                    tal[n] = tal[n + 1];
                    tal[n + 1] = temp;
                }
            }
        }
        for (int n : tal) {
            if (n != 0) {
                System.out.println(n);
            }
        }
    }
}
