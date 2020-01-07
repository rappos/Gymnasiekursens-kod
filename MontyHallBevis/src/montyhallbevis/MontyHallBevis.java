package montyhallbevis;

import java.util.concurrent.ThreadLocalRandom;

public class MontyHallBevis {

    public static final int spel = 100000;
    public static String[] lista = new String[3];
    public static final int min = 0;
    public static final int max = 2;

    public static void main(String[] args) {
        lista[0] = "get";
        lista[1] = "get";
        lista[2] = "get";

        int bilensPlats = ThreadLocalRandom.current().nextInt(min, (max + 1));
        lista[bilensPlats] = "bil";

        int stanna = stannaDörr();

        int byter = bytaDörr();

        System.out.println("Stanna med samma plats gav " + stanna + " vinster");
        System.out.println("Byte av platsen gav " + byter + " vinster");
    }

    static int bytaDörr() {
        int vinst = 0;
        int i;

        for (i = 0; i < spel; i++) {
            int val1 = ThreadLocalRandom.current().nextInt(min, (max + 1));
            if (lista[val1].equals("get")) {
                vinst++;
            }

        }

        return vinst;
    }

    static int stannaDörr() {
        int vinst = 0;
        int i;
        for (i = 0; i < spel; i++) {
            int val1 = ThreadLocalRandom.current().nextInt(min, (max + 1));

            if (lista[val1].equals("bil")) {
                vinst++;
            }

        }

        return vinst;
    }
}
