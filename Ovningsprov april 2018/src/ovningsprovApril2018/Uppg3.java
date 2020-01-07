package ovningsprovApril2018;


import java.util.InputMismatchException;
import java.util.Scanner;

//Läs in ett antal tal och sortera dem efter om de är udda eller jämna
public class Uppg3 {

    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner sc = new Scanner(System.in);
        int antalTal=0;
        while(antalTal<array.length){
            //Inläsning med felhantering
            try{
                System.out.print("Skriv ett heltal (0 avslutar): ");
                array[antalTal]=sc.nextInt();
                if(array[antalTal]!=0) antalTal++;
                else break;
            }
            catch(InputMismatchException e){
                //Felaktig inmatning
                System.out.println("Skriv ett heltal!");
                sc.next(); //Läs in misslyckat tal som sträng och släng bort.
            }
        }
        bubbleSortOddEven(array,antalTal);
        System.out.println("Sortera med udda tal först:");
        for(int i=0;i<antalTal;i++){
            System.out.println(array[i]);
        }       
    }
    
    //Enklast möjliga bubbelsortering av arrayen data
    //Sorterar de första n talen i arrayen data
    //så att udda tal kommer före jämna. I övrigt behålls ordningen
    //n är alltså antalet element att sortera
    public static void bubbleSortOddEven(int[] data,int n){
        for(int j=0;j<n-1;j++){ //Kör n-1 varv
            for(int i=0;i<n-1;i++) {
                //i pekar på det element som ska jämföras med sin granne.
                //Byt plats om element i och i+1 ligger i fel ordning
                //(dvs om det första elementet är jämt och det andra udda
                if(!isOdd(data[i]) && isOdd(data[i+1])) swap(data, i,i+1);
            }
        }
    }
    
    //Returnerar true om ett tal är udda, annars false.
    public static boolean isOdd(int n){
        return n%2!=0; //För ett udda n blir resten vid div med 2 inte noll
    }
 
    //Byt plats på två element (index i och j) i arrayen data
    public static void swap(int[] data,int i,int j)
    {
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }


}
