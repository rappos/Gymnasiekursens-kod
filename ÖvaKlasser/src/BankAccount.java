
public class BankAccount {

    private int balance; //Saldo
    private int number; //Kontonummer
    private String holderName; //Ägarens namn
    private int maxCredit; //Maxskulden 

    public BankAccount(int bal, int num, String name, int debt) {
        balance = bal;
        number = num;
        holderName = name;
        maxCredit = debt;
    }

    public int getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getNumber() {
        return number;
    }

    public boolean withdraw(int amount) { //Ta ut pengar
        if (balance >= maxCredit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(int amount) { //Sätt in pengar
        balance += amount;
    }

    @Override
    public String toString() {
        return number + "\t" + holderName + "\t" + balance + " kr";
    }

    public static String tableHeader() {
        return "Kontonr" + "\t" + "Ägarnamn" + "\t" + "Behållning";
    }
}
