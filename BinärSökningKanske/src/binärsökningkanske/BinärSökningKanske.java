package binärsökningkanske;

import java.util.Scanner;

public class BinärSökningKanske {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vilket tal sökes?");
        int tal = input.nextInt();
        int talen[] = new int[]{2, 6, 7, 9, 12, 15, 17, 18, 21, 23, 24, 26, 27, 32, 34, 35, 37, 39, 40, 43, 45, 46, 47, 49, 50, 51, 52, 53, 54, 56, 59, 60, 63, 64, 66, 67, 73, 74, 75, 76, 78, 79, 81, 82, 84, 87, 88, 91, 92, 95, 97, 98, 99, 102, 104, 105, 106, 109, 113, 114, 115, 116, 118, 119, 120, 121, 123, 124, 127, 128, 131, 136, 137, 138, 142, 143, 144, 145, 146, 149, 150, 154, 155, 162, 163, 165, 166, 176, 177, 180, 182, 184, 185, 190, 191, 192, 196, 197, 198, 199};
        System.out.println("Ditt sökta tal " + tal + " fanns vid index " + sök(talen, tal));
    }

    private static int sök(int[] arr, int num) {
        int firstNum = 0;
        int lastNum = arr.length - 1;
        while (lastNum >= firstNum) {
            int middle = (firstNum + lastNum) / 2;
            if (arr[middle] == num) {
                return middle;
            } else if (arr[middle] < num) {
                firstNum = middle + 1;
            } else if (arr[middle] > num) {
                lastNum = middle - 1;
            }
        }
        return -1;
    }
}
