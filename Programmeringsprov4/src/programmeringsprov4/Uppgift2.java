package programmeringsprov4;
//Tror inte jag behövde göra denna, men gör för säkerhets skull

import java.util.Scanner;

public class Uppgift2 {

    public static void main(String[] args) {
        int[] array = new int[4];
        Scanner input = new Scanner(System.in);

        System.out.println("Du ska få skriva in fyra heltal");
        for (int i = 0; i < 4; i++) {
            System.out.println("Skriv in ett tal!");
            array[i] = input.nextInt();
        }

        System.out.println("De av talen som är mindre än 10: ");
        for (int i = 0; i < 4; i++) {
            if (array[i] < 10) {
                System.out.println(array[i]);
            }
        }
    }
}
