import model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamEx2Test {

    static Stream<? extends Arguments> provideToUpperCaseExpectedResult() {
        return Stream.of(
                Arguments.of(Arrays.asList("a","B","c"), Arrays.asList("A","B","C"))
        );
    }

    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @MethodSource("provideToUpperCaseExpectedResult")
    public void testToUpperCase(List givenValue, List expected){
        //Given

        //When
        StreamExSet2 streamEx= new StreamExSet2();
        //Then
        assertThat(streamEx.toUpperCase(givenValue)).isEqualTo(expected);
    }


    static Stream<? extends Arguments> provideFlatCollectionExpectedResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(Arrays.asList("a","B","c"), Arrays.asList("A","B","C")),Arrays.asList("a","B","c","A","B","C"))
        );
    }
    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @MethodSource("provideFlatCollectionExpectedResult")
    public void testFlatCollection(List givenValue, List expected){
        //Given

        //When
        StreamExSet2 streamEx= new StreamExSet2();
        //Then
        assertThat(streamEx.flatCollection(givenValue)).isEqualTo(expected);
    }


    @Test
    public void testGroupByNationality(){
        //Given

        //When
        StreamExSet2 streamEx= new StreamExSet2();
        Map<String,List<String>> expected=new HashMap<String, List<String>>()
        {
            {
                put("BE", Arrays.asList("Tom", "Franck"));
                put("FR", Arrays.asList("Jim", "Joe"));
                put("UK", Arrays.asList("André"));
            }};
        //Then
        assertThat(streamEx.groupByNationality (Person.createPersonsList())).isEqualTo(expected);
    }



}
