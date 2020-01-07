package linkedlisttest;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class LinkedListTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        LinkedList<Integer> lista = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(rand.nextInt(10) + 1);
        }
        System.out.println("Innan: ");
        System.out.println(lista);

        sort(lista);
        System.out.println("Efter: ");
        System.out.println(lista);
    }

    private static void sort(LinkedList<Integer> lista) {
        for (int m = lista.size() - 1; m > 0; m--) {
            for (int n = 0; n < m; n++) {
                if (lista.get(n) > lista.get(n + 1)) {
                    int temp = lista.get(n);
                    lista.set(n, lista.get(1 + n));
                    lista.set(n + 1, temp);
                }
            }
        }
    }

}
