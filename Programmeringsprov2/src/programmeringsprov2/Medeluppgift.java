package programmeringsprov2;
//Programmet skriver ut en slumpad veckodag och ett datum i november. Slutar när tisdag 28 november kommer upp

import java.util.Random;

public class Medeluppgift {

    public static void main(String[] args) {

        int antalFörsök = 1;

        while (true) {
            String dag = slumpaDag();
            int datum = slumpaDatum();

            System.out.println(dag + " " + datum + " november");
            if ("Tisdag".equalsIgnoreCase(dag) && 28 == datum) {                                    //Körs om det blir dagens datum
                System.out.println("Antal försök som krävdes: " + antalFörsök);
                break;
            }
            antalFörsök++;
        }
    }

    private static String slumpaDag() {
        Random rand = new Random();  //Random-klassen för slumpade tal

        String[] dagar = new String[]{"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};
        int valdDag = rand.nextInt(7); //Slumpar ett tal mellan 0 och 7, exkluderande för 7 (0,1,2,3,4,5,6)

        String dag = dagar[valdDag];
        return dag;
    }

    private static int slumpaDatum() {
        Random rand = new Random();

        int valtDatum = rand.nextInt(30) + 1; //plus ett för att inte få dag 0 och att få med 30 som möjlighet
        return valtDatum;
    }
}
