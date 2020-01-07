package programmeringsprov2;

//Testar en metod som multiplicerar 2 stycken tal 
public class Uppgift2 {

    public static void main(String[] args) {

        double tal1 = 2.17;
        double tal2 = 12.01;

        System.out.println("Test med multiplikation av " + tal1 + " och " + tal2 + " (" + tal1 + " x " + tal2 + "):");
        double produkt = räknaProdukt(tal1, tal2);
        System.out.println("Produkten blir " + produkt);

    }

    private static double räknaProdukt(double tal1, double tal2) {
        double produkt = tal1 * tal2;
        return produkt;
    }

}
