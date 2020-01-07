
import java.util.Scanner;

public class UppgiftEtt {

    public static void main(String[] args) {
        boolean bamboozel = true;
        Scanner input = new Scanner(System.in);
        BankAccount acc = new BankAccount(12, 1222, "Kalle", -100);
        while (bamboozel) {
            System.out.println("1. Visa Behållning \n2. Sätt in pengar \n3. Ta ut pengar \n4. Avsluta");
            System.out.print("Svar: ");
            int svar = input.nextInt();

            switch (svar) {
                case 1:
                    System.out.print("Behållning: ");
                    System.out.print(acc.getBalance() + "kr");
                    break;
                case 2:
                    System.out.println("Hur mycket ska vi sätta in?");
                    System.out.print("Kronor: ");
                    acc.deposit(input.nextInt());
                    System.out.println("Kronor efter insättning: " + acc.getBalance());
                    break;
                case 3:
                    System.out.println("Hur mycket ska tas ut?");
                    System.out.print("Kronor: ");
                    acc.withdraw(input.nextInt());
                    System.out.println("Kronor kvar: " + acc.getBalance());
                    break;
                case 4:
                    System.out.println(acc);
                    System.out.println("Hejdå!");
                    bamboozel = false;
                    break;

                default:
                    System.out.println("Fel");
                    break;
            }
            System.out.println();
        }

    }

}
