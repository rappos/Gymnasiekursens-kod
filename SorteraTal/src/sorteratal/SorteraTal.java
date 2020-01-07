package sorteratal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SorteraTal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vi ska sortera dina tal i sorleksordning");
        System.out.println("Hur många tal vill du sortera?");
        System.out.print("Antal: ");
        int längd = input.nextInt();
        double[] lista1 = new double[längd];
        double[] lista2 = new double[längd];

        int i;
        for (i = 0; i < längd; i++) {
            System.out.print("Tal " + (i + 1) + ": ");
            lista1[i] = input.nextDouble();
        }
        double z = 0;
        for (i = 0; i < längd; i++) {
            if (lista1[i] > z) {
                z = lista2[i];
            }
        }

            
            
        }
    }

    

