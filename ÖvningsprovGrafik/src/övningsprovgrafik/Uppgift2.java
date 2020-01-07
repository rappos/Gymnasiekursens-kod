package övningsprovgrafik;

public class Uppgift2 {

    public static void main(String[] args) {
        int[] talen = new int[]{1, 2, 132, 143, 32, 12, 3, 5};
        dubblaArray(talen);
        
        for (int i = 0; i < (talen.length - 1); i++) {
            System.out.println(talen[i]);
        }
    }

    private static void dubblaArray(int[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            arr[i] = arr[i] * 2;
        }
    }
}
