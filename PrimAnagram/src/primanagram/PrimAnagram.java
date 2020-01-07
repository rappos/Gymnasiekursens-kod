package primanagram;

import java.util.Scanner;

public class PrimAnagram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = 2;
        int b = 5;
        int c = 7;
        int d = 11;
        int e = 13;
        int f = 17;
        int g = 19;
        int h = 23;
        int i = 29;
        int j = 31;
        int k = 37;
        int l = 41;
        int m = 43;
        int n = 47;
        int o = 53;
        int p = 59;
        int q = 61;
        int r = 67;
        int s = 71;
        int t = 73;
        int u = 79;
        int v = 83;
        int w = 89;
        int x = 97;
        int y = 101;
        int z = 103;
        int å = 107;
        int ä = 109;
        int ö = 113;

        System.out.println("Nu ska vi kolla anagram!");
        System.out.print("Ord 1: ");
        String ord1 = input.next();
        System.out.print("Ord 2: ");
        String ord2 = input.next();

        int längd1 = ord1.length();
        int längd2 = ord2.length();
        int produkt;
        int produkt1 = 1;
        int produkt2 = 1;
        int noll;

        if (längd1 == längd2) {
            for (noll = 0; noll < längd1; noll++) {
                produkt = ord1.charAt(noll);
                produkt1 = produkt * produkt1;
            }
            for (noll = 0; noll < längd2; noll++) {
                produkt = ord2.charAt(noll);
                produkt2 = produkt * produkt2;
            }
            System.out.println("Dina ord " + ord1 + " och " + ord2 + " är anagram");
        } else {
            System.out.println("Dina ord är inte lika långa. Då kan de inte vara anagram");

        }

        System.out.println("Klart!");
    }

}
