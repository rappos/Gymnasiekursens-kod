package projecteuler;

public class E6 {

    public static void main(String[] args) {
        long sumSquare = 0;
        long squareSum = 0;
        for (int i = 1; i <= 100; i++) {
            sumSquare = (long) ((sumSquare + Math.pow(i, 2)));
        }
        for (int i = 1; i <= 100; i++) {
            squareSum = (long) (squareSum + i);
        }
        squareSum = (long) Math.pow(squareSum, 2);

        long svar = (squareSum - sumSquare);
        System.out.println(svar);
    }
}
