package uppgift42;

import java.util.Scanner;

public class Uppgift42 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Tänk på ett heltal: ");
        int heltal = input.nextInt();
        int svar = ((((((heltal+1)*2)-6)/2)+3)-heltal);
        System.out.println(svar);
        
    }

}
