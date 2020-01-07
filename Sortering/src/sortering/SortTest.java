package sortering;

public class SortTest {
    public static void main(String[] args) {
        //double[] array = { 67, 54, 76, 63, 34, 95, 55 };
        double[] array = Sort.getRandomDoubleArray(1000);
        System.out.println("Före sortering:");
        printDoubleArray(array);
        Sort.bubbleSortSimple(array,array.length);
        //Sort.selectionSort(array,array.length);
        //Sort.insertionSort(array,array.length);
        //Sort.mergeSort(array, 0,array.length);
        System.out.println("Efter sortering:");
        printDoubleArray(array);
    }
    
    // Skriv ut en hel array med double
    // Om arrayen är lång måste man högerklicka i Console-fönstret och
    // välja Preferences och sedan stänga av "Limit console output"
    public static void printDoubleArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t"); // Talet och ett tab-tecken
        }
        System.out.println(); // En radmatning tillslut
    }
}
