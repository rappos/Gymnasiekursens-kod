package projecteuler;

public class E7 {

    public static void main(String[] args) {
        int prime = 0;
        for (int i = 0; i==i; i++) {
            if (isPrime(i)) {
                prime++;
                System.out.println(i);
            }
            if(prime==10001){
                System.out.println();
                System.out.println(i);
                break;
            }
        }
    }
//checks whether an int is prime or not.

    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
