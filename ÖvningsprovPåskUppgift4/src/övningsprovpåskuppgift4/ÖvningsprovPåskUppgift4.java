package övningsprovpåskuppgift4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ÖvningsprovPåskUppgift4 {

    public static void main(String[] args) {
        int antalPersoner = 0;

        Person[] person = new Person[100];
        Scanner input = new Scanner(System.in);
        while (antalPersoner < 100) {
            System.out.println("Skriv \"stopp\" för att stoppa");
            try {
                System.out.println("Namn: ");
                String tempName = input.next();
                if (tempName.equalsIgnoreCase("stopp")) {
                    break;
                }
                System.out.println("Födelseår: ");
                int tempYear = input.nextInt();
                person[antalPersoner] = new Person(tempName, tempYear);
                antalPersoner++;
            } catch (InputMismatchException e) {
                System.out.println("Försök igen");
                input.next();
            }

        }
        while (true) {
            System.out.println("Vill du sortera listan?");
            System.out.println("1. Nej \n2. Ja efter namn \n3. Ja efter födelseår");
            switch (input.nextInt()) {
                case 1:
                    PrintPerson(antalPersoner, person);
                    break;
                case 2:
                    sorteraEfterNamn(person, antalPersoner);
                    PrintPerson(antalPersoner, person);
                    break;
                case 3:
                    sorteraEfterÅr(person, antalPersoner);
                    PrintPerson(antalPersoner, person);
                    break;
                default:
                    System.out.println("Försök igen");
            }
            break;
        }
    }

    private static void PrintPerson(int antalPersoner, Person[] person) {
        for (int i = 0; i < antalPersoner; i++) {
            System.out.println(person[i].toString());
        }
    }

    private static void sorteraEfterNamn(Person[] person, int längd) {
        int i;
        Person temp;
        for (int n = 1; n < längd; n++) {
            temp = person[n];
            i = n - 1;
            while (i >= 0 && person[i].getName().compareToIgnoreCase(temp.getName()) > 0) {
                person[i + 1] = person[i];
                i--;
            }
            person[i + 1] = temp;
        }
    }

    private static void sorteraEfterÅr(Person[] person, int längd) {
        int i;
        Person temp;
        for (int n = 1; n < längd; n++) {
            temp = person[n];
            i = n - 1;
            while (i >= 0 && person[i].getBirthYear() > temp.getBirthYear()) {
                person[i + 1] = person[i];
                i--;
            }
            person[i + 1] = temp;
        }
    }
}
