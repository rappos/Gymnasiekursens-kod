package uppgift32;

import java.util.Scanner;

public class Uppgift32 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vi ska byta plats på dina 4 tal");
        int[] tal = new int[4];
        int temp;
        int i = 0;

        while (i < 4) {
            System.out.print("Skriv tal " + (1 + i) + ": ");
            tal[0 + i] = input.nextInt();
            i++;
        }
        temp = tal[0];
        tal[0] = tal[3];
        tal[3] = temp;
        temp = tal[1];
        tal[1] = tal[2];
        tal[2] = temp;

        System.out.print("Dina tal i omvänd ordning är: ");
        i = 0;
        while (i < 4) {
            System.out.print(tal[(0 + i)] + " ");
            i++;
        }

    }

}
