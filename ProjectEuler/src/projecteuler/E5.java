package projecteuler;

public class E5 {

    public static void main(String[] args) {
        int boi = 0;
        for (int i = 2520;; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i % j == 0) {
                    boi++;
                }
                if (boi == 20) {
                    System.out.println(i);
                    break;
                }
            }
            boi = 0;
        }
    }
}
