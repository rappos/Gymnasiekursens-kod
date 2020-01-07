package ovningsprovApril2018;

import java.util.Scanner;

public class Uppg4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] array =new Person[100];
        int numPeople = 0; //Antal personer i arrayen
        //Slinga som läser in persondata
        while(true) {
            System.out.print("Efternamn (q avslutar): ");
            String name =sc.next();
            if(name.equals("q")) break;
            int year;
            //Slinga för att läsa in ett år. Kör till lyckad inmatning.
            while(true){ //Fortsätt till break
                try{
                    System.out.print("Födelseår: ");
                    year = sc.nextInt();
                    break; //Inläsning lyckad
                }
                catch(Exception e){
                    System.out.println("Skriv ett heltal!");
                    sc.next(); //Läs in misslyckat år som sträng och släng bort.

                }
            }
            array[numPeople]=new Person(name,year);
            numPeople++;
            if(numPeople==array.length){
                System.out.println("Arrayen full! Avbryter inmatning");
                break;
            }
        }
        System.out.println("Inmatad lista");
        printArray(array, numPeople);
        
        System.out.print("Sortera  på år (j/n, annars sorteras på namn)? ");
        if(sc.next().charAt(0)=='j'){
            //Sortera på år
            sort(array,numPeople,true);
        }
        else {
            //Sortera på namn
            sort(array,numPeople,false);
        }
        System.out.println("Sorterad lista");
        printArray(array, numPeople);       
    }

    
    //Insertion sort (infogande sortering)
    //Sorterar de första n personerna i arrayen data
    //Sorterar efter år om sortAccordingToYear är sann, annars efter namn
    public static void sort(Person[] data, int n, boolean sortAccordingToYear){
        //Början av listan sorteras genom att vi sätter in
        //ett element i taget från den osorterade delen av listan.
        //Vi tar då det första osorterade elementet (firstUnsorted nedan)
        //och sätter in det på rätt plats (som ska pekas ut av i nedan).
        for(int firstUnsorted=1;firstUnsorted<n;firstUnsorted++){
            int i=firstUnsorted; //i är ett index som ska flyttas så att det pekar
            //där ett element ska infogas.
            //Det första osorterade elementet ska sättas in i den sorterade delen:
            Person valueToInsert=data[firstUnsorted];
            //Nu flyttar vi i stegvis mot början av listan tills vi hittar rätt
            //plats att sätta in valueToInsert på.
            while(i>0 && data[i-1].compareTo(valueToInsert, sortAccordingToYear)>0){
                //valueToinsert ska vara före element i-1
                data[i]=data[i-1]; //element i-1 flyttas mot slutet av listan för att ge plats
                i--; //Nästa varv tittar vi om nästa element också är större
            }
            //Gör insättningen om elementet inte ska vara kvar på samma ställe
            if(i!=firstUnsorted){
                data[i]=valueToInsert;
            }
        }
    }

    //Utskrift av n element ur array med personer
    private static void printArray(Person[] array, int n) {
        for(int i=0;i<n;i++){
            System.out.println(array[i]);
        }
    }

}
