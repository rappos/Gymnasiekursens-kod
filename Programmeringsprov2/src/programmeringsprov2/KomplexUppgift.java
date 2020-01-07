package programmeringsprov2;

//Skriver ut mönstret i uppgiften i oöndligeheten, enligt reglerna i uppgiftens beskrivning
public class KomplexUppgift {

    public static void main(String[] args) {
        int[] antalMellanrum = new int[]{0, 3, 9, 15, 18, 18, 15, 9, 3, 0};
        while (true) {
            for (int i = 0; i < 10; i++) {                                                     //Huvudloopen kör en gång per tal i mellanrumsarrayen  
                System.out.println();
                for (int j = 0; j < antalMellanrum[i]; j++) {                           //skriver ut antal mellanrum
                    System.out.print(" ");
                }
                System.out.print("*");
                delay();
            }
        }
    }

    private static void delay() {                                           //Vid provtillfället gav denna en lagom hastighet
        for (int i = 0; i < 1100000; i++) {
            for (int j = 0; j < 500; j++) {

            }

        }
    }

}
