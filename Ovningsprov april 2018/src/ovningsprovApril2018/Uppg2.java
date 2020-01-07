package ovningsprovApril2018;


import java.util.Scanner;


public class Uppg2 {

    //Läs in fem tal och sortera dem med bubblesort
    public static void main(String[] args) {
        double[] array = new double[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<array.length;i++){
            System.out.print("Skriv ett tal: ");
            array[i]=sc.nextInt();
        }
        bubbleSortSimple(array, array.length);
        System.out.println("Sorterat:");
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        

    }
    
    //Kopierad från Sort.java
    //Enklast möjliga bubbelsortering av arrayen data
    //Sorterar de första n talen i arrayen data
    //n är alltså antalet element att sortera
    public static void bubbleSortSimple(double[] data,int n){
        for(int j=0;j<n-1;j++){ //Kör n-1 varv
            for(int i=0;i<n-1;i++) {
                //i pekar på det element som ska jämföras med sin granne.
                //Byt plats om element i och i+1 ligger i fel ordning (bokstavsordn)
                if(data[i]>data[i+1]) swap(data, i,i+1);
            }
        }
    }
 
    //Kopierad från Sort.java
    //Byt plats på två element (index i och j) i arrayen data
    public static void swap(double[] data,int i,int j)
    {
        double temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }


}
