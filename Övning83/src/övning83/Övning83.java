package övning83;

public class Övning83 {

    public static void main(String[] args) {
  

        int[] hastighet = new int[8];

        System.out.println("m/s \tkm/h ");
        for (int n = 0; n < hastighet.length; n++) {
            hastighet[n] = 5 * (n + 1);
            System.out.println((hastighet[n]) + "\t" + hastighet[n] * 3.6);

        }

    }

}
