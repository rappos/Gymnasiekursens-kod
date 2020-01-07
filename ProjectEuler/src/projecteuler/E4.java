package projecteuler;

public class E4 {

    public static void main(String[] args) {

        for (int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                int boi = (Integer.parseInt(new StringBuilder((i * j) + "").reverse().toString()));
                if ((i * j) == boi) {
                    System.out.println(i * j);
                }
            }
        }

    }

}
