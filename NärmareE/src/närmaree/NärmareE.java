package närmaree;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class NärmareE {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int i;
        int tal1 = 1;
        double tal2;
        double tal3;
        double tal4;
        double tal5;
        double tal6;

        for (i = 1; i < 1000; i++) {

            tal2 = i;
            tal3 = (tal1 / tal2);
            tal4 = (tal3 + tal1);
            double resultat = Math.pow(tal4, tal2);
            System.out.println(resultat);
            TimeUnit.SECONDS.sleep(1);

        }

    }

}
