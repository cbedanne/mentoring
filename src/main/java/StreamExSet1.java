import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class StreamExSet1 {
    public int getSumFrom1(int givenValue) {
        return Stream
                .iterate(1, integerValue -> integerValue + (1))
                .limit(givenValue).mapToInt(Integer::intValue).sum();
    }

    public int getSumOfSquareFrom1(int givenValue) {
        return IntStream
                .rangeClosed(1,givenValue)
                .reduce((x,y)-> (int) (x+Math.pow(y,2)))
                .getAsInt();
    }

    public int getSumOfEvenFrom1(int givenValue) {
        return Stream.iterate(
                1, integerValue ->
                        integerValue + (1))
                .limit(givenValue)
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum).get();
    }

    public Map<Boolean,Integer> getSumOfEvenAndOddFrom1(int givenValue) {
        return Stream.iterate(
                1, integerValue ->
                        integerValue +(1))
                .limit(givenValue)
                .collect(Collectors.groupingBy(n->n%2==0,Collectors.summingInt(Integer::intValue)));
    }

    public List<Integer> getFacteursPremiers(int givenValue) {
         return Stream.iterate(givenValue, integerValue -> integerValue / ppd(integerValue))
                 .map(this::ppd)
                 .limit(givenValue)
                 .filter(e->e>1)
                 .collect(toList());
    }

    public Integer ppd(Integer dividedValue) {
        Optional<Integer> ppd= Stream.iterate(2, integerValue -> integerValue +(1))
                .limit(dividedValue)
                .filter(n-> dividedValue %n==0)
                .findFirst();

        return ppd.orElse(1);
    }

}
