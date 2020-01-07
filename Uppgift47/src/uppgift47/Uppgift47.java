package uppgift47;

import java.util.Scanner;

public class Uppgift47 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ange antalet sekunder: ");
        int sekunder = input.nextInt();
        int minuter = 0;
        int timmar = 0;

        while (sekunder >= 60) {
            minuter = (minuter + 1);
            sekunder = (sekunder - 60);
        }

        while (minuter >= 60) {
            timmar = (timmar + 1);
            minuter = (minuter - 60);
        }

        if (timmar > 0) {
            if (timmar == 1) {
                System.out.print(timmar + " timme ");
            } else {
                System.out.print(timmar + " timmar ");
            }

        }
        if (minuter > 0) {
            if (minuter == 1) {
                System.out.print(minuter + " minut ");
            } else {
                System.out.print(minuter + " minuter ");
            }
        }
        if (sekunder > 0) {
            if (sekunder == 1) {
                System.out.print(sekunder + " sekund ");
            } else {
                System.out.print(sekunder + " sekunder ");
            }
        }

    }

}
