package övning.pkg31.förbättring;

import java.util.Scanner;

public class Övning31Förbättring {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hur många tal vill du ha i listan?");
        System.out.print("Antal: ");
        int antal = input.nextInt();

        System.out.println("Du valde att ha " + antal + " tal i listan");
        
        int[] lista = new int[antal];
        int i = 0;
        while (i < antal) {
            System.out.print("Tal " + (i + 1) + ": ");
            lista[0 + i] = input.nextInt();
            i++;

        }
        int k = 0;
        System.out.print("Dina tal var: ");
        while (k < antal) {
            System.out.print(lista[k] + " ");
            k++;
        }
    }

}
