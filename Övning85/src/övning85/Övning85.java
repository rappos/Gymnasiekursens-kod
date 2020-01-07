package övning85;

public class Övning85 {

    public static void main(String[] args) {

        for (int rad = 1; rad <= 10; rad++) {

            System.out.println();

            for (int kolumn = 1; kolumn <= 10; kolumn++) {

                if (rad > (kolumn - 1)) {
                    System.out.print(kolumn * rad + "\t");
                }
            }
        }
        System.out.println();
    }
}
