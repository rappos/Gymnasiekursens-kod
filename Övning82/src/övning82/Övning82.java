package övning82;

import java.util.Scanner;

public class Övning82 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Minsta talet: ");
        int start = input.nextInt();
        System.out.print("Största talet: ");
        int slut = input.nextInt();
        System.out.print("Steglängd: ");
        int steg = input.nextInt();

        for (int i = slut; start <= i; i = (i - steg)) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

}
