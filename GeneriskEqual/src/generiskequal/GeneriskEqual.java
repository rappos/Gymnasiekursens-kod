package generiskequal;

import java.math.BigInteger;

import java.util.ArrayList;

public class GeneriskEqual {

    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(12);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("12");

        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(12.000000000000000000000000000000000000);

        ArrayList<Boolean> booleanList = new ArrayList<>();
        booleanList.add(!false);

        ArrayList<BigInteger> bigIntList = new ArrayList<>();
        bigIntList.add(new BigInteger("12"));

        isSame(intList, bigIntList);

    }

    private static <T, U> void isSame(ArrayList<T> arr1, ArrayList<U> arr2) {
        System.out.println(arr1.get(0) == arr2.get(0));
    }

}
