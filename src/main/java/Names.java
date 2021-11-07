import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Names {

    public int lettercountForNamesGreaterThan5(String ... names){

        return Arrays.stream(names)
                .filter(name->name.length()>5)
                .map(String::length)
                .collect(Collectors.summingInt(Integer::intValue));
    }

//    Write a method that returns a comma separated string based on a given list of integers.
//    Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
//    For example, if the input list is (3,44), the output should be 'o3,e44'.

    public String getIntegerAsOddEvenString(List<Integer> list) {
        String result= list.stream().map(i -> i % 2 == 0 ? "e" + i : "o" + i).collect(joining(","));
        return result;
    }



}
