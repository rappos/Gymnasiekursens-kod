package ovningsprovApril2018;

import java.util.Scanner;

//Program som läser in ett tecken och kollar om det är en siffra
public class Uppg1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Skriv ett tecken: ");
        char ch = sc.next().charAt(0);
        if(isNumber(ch)){
            System.out.println("Siffra");
        }
        else {
            System.out.println("Inte siffra.");
        }
    }
    
    // Returnera true om tecknet c är en siffra
    public static boolean isNumber(char c){
         char[] numbers={'0', '1', '2', '3', '4','5', '6', '7', '8', '9'};
         for(int i=0;i<numbers.length;i++){
             if(c==numbers[i]) {
                 return true;   //returnera direkt om c är en av siffrorna
             }
         }
         //Slingan är slut och har gått igenom hela arrayen
         return false; //Ingen matchande siffra hittades eftersom vi kommit hit
     }
}
