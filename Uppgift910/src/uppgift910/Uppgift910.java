package uppgift910;

import java.util.Arrays;
import java.util.Scanner;

public class Uppgift910 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hur många tal i arrayen? : ");
        int antal = input.nextInt();
        double[] falt = new double[antal];
        for (int i = 0; i < antal; i++) {
            System.out.print("Tal " + (i + 1) + ": ");
            falt[i] = input.nextDouble();
        }

        double variationsbredd = variationsbredd(falt, antal);
        System.out.println(variationsbredd);
    }

    static double variationsbredd(double falt[], int antal) {

        Arrays.sort(falt);
        Double svar = falt[antal - 1] - falt[0];
        return svar;
    }

}
