package print_fibonacci;

import java.util.Scanner;

public class Print_fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tal1 = 1;
        int tal2 = 1;
        int i;
        for (i = 0; i < 100; i++) {
            System.out.println(tal1);
            System.out.println(tal2);
            tal1 += tal2;
            tal2 += tal1;
        }
    }

}
