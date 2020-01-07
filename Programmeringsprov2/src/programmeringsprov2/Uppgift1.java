package programmeringsprov2;

import java.util.Scanner;

//Användaren skriver in ett tal som sedan blir första av fem tal, vartannat från start, att fylla en array. Sist skrivs arrayen ut.
public class Uppgift1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] tal = new int[5];

        System.out.print("Ange ett heltal: ");
        int start = input.nextInt();

        for (int i = 0; i < 5; i++) {
            tal[i] = start + 2 * i;
        }
        System.out.println("Vartannat heltal: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(tal[i]);
        }
    }

}
