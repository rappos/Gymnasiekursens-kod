package djurpark;

import java.util.Scanner;


public class Djurpark {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Animal[] animal = new Animal[100];
        int antalDjur = 1;
        while (true) {
            System.out.println("\nVad vill du göra?\n");
            System.out.println("1. Lägg till djur \n2. Göra köttbullar av djuren\n3. Titta på djur");
            int val = input.nextInt();
            switch (val) {
                case 1:
                    System.out.println("Vad är ditt djur för djur?");
                    String djur = input.next();
                    System.out.println("Vad heter ditt djur?");
                    String namn = input.next();
                    animal[antalDjur] = new Animal(djur, namn);
                    antalDjur++;
                    break;
                case 2:
                    System.out.println("Nämen va elakt, nu finns inga djur kvar :( ");
                    for (int i = 1; i < (antalDjur); i++) {
                        animal[i] = null;
                    }
                    break;
                case 3:
                    for (int i = 1; i < (antalDjur); i++) {
                        if (animal[i] != null) {
                            animal[i].viewAnimal();
                        }
                    }
                    break;
                default:
                    System.out.println("Error! Error code: 143");
                    break;
            }
        }
    }
}
