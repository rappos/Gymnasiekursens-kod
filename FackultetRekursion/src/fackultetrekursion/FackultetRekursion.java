package fackultetrekursion;

import java.util.Scanner;

public class FackultetRekursion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nSkriv tal: ");
            System.out.println("Svar: " + fackultet(input.nextInt()));
        }

    }

    private static int fackultet(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fackultet(n - 1);
        }
    }

}
