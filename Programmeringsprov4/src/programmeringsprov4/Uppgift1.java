package programmeringsprov4;

import java.util.Scanner;

public class Uppgift1 {

    public static void main(String[] args) {

        String[] array = new String[4];
        Scanner input = new Scanner(System.in);

        System.out.println("Du ska få skriva in fyra ord");

        for (int i = 0; i < 4; i++) {
            System.out.print("Ord " + (i + 1) + ": ");
            array[i] = input.next();
        }

        for (int i = 0; i < 4; i++) {
            if (array[i].length() != 4) {              //Kollar om något av orden EJ är fyra tecken långt
                System.out.println("inte");         //Isåfall skrivs "inte" och slingan bryts
                break;
            }
        }
        System.out.println("fyra gånger fyra!");        //Detta ska enligt instruktionen skrivas oavsett resultat i slingan, så den finns längst ner
    }
}
