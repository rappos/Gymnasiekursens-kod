package uglycounter;

class UglyCounter {

    public static void main(String[] args) {
        int lastNumber = 100000000;
        int counter = lastNumber;
        int display = counter - lastNumber;
        while (lastNumber <= counter) {
            if (display != (lastNumber - counter)) {
                System.out.println(display);
            }
            try {
                lastNumber = lastNumber / counter;
                counter--;
                display++;
            } catch (Exception e) {
                break;
            }
        }
    }
}
