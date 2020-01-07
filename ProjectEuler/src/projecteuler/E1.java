package projecteuler;

public class E1 {

    public static void main(String[] args) {
        int total = 0;

        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0) {
                total = total + i;
            }
            if (i % 5 == 0) {
                total = total + i;
            }
            if (i % 3 == 0 && i % 5 == 0) {
                total = total - i;
            }
        }
        System.out.println(total);
    }
}
