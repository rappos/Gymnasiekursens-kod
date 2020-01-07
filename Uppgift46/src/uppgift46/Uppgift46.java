package uppgift46;

import java.util.Scanner;

public class Uppgift46 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ange antalet timmar: ");
        double h = input.nextDouble();
        System.out.print("Ange antalet minuter: ");
        double m = input.nextDouble();
        System.out.print("Ange antalet sekunder: ");
        double s = input.nextDouble();

       double timmar = (h+(m/60)+(s/3600));
       double minuter = ((h*60)+m+(s/60));
       double sekunder = ((h*3600)+(m*60)+s);
        
        System.out.println("Tidsomvandling ger: ");
        System.out.println(timmar + " timmar = " + minuter + " minuter = " + sekunder + " sekunder");
    }

}
