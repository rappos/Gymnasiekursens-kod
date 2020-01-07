package projecteuler;

public class E12 {

    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        int divis = 0;
        while (true) {
            sum = (sum + i);

            for (int j = 1; j < sum; j++) {
                if (sum % j == 0) {
                    divis++;
                }

            }
            if (divis >= 500) {
                System.out.println(sum);
            } else {
                divis = 0;
            }
            i++;
        }
    }

}
