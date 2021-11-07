package selflearning.Lambdas_functinterface;

import java.util.Arrays;

public class SortArraysOfString {

    static void sortLargeNumbers(String[] arr) {
        Arrays.sort(arr, (left, right) ->
        {
            if (left.length() != right.length()) return left.length() - right.length();
            return left.compareTo(right);
        });

    }

    public static void main(String[] args) {
        String[] arr={"5","123456789123456789456987452","9587","4","12","1245"};
        sortLargeNumbers(arr);
        Arrays.stream(arr).peek(System.out::println).count();

    }

}
