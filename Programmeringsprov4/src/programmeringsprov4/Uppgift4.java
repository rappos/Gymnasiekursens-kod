package programmeringsprov4;

public class Uppgift4 {

    public static void main(String[] args) {
        int[] testArr = new int[]{2, 4, 3, 8, 10, 1, 7, 6, 5, 9};
        int index = 0;
        System.out.println("Innan: ");
        soutArray(testArr);

        tomtesortering(testArr, index);

        System.out.println("\nEfter: ");
        soutArray(testArr);
    }

    private static void tomtesortering(int[] arr, int index) {
        while (index < arr.length - 1) {            //Slutar när index/tomten går utanför arrayens slut
            if (arr[index] > arr[index + 1]) {        //Byter om talen är i fel ordning
                swap(arr, index);
                if (index > 0) {                              //Minskar index (backar) om det inte redan är 0
                    index--;
                }
            } else {
                index++;                                      //Går fram om inget byte skedde
            }
        }
    }

    private static void swap(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[index + 1];
        arr[index + 1] = temp;
    }

    private static void soutArray(int[] testArr) {
        for (int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + ", ");
        }
    }
}
