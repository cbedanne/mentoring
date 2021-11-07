import model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterCollectionTest {

    static Stream<? extends Arguments> provideShorterThan4CharactExpectedResult() {
        return Stream.of(
                Arguments.of(Arrays.asList("abcd","ABC",""), Arrays.asList("ABC",""))
        );
    }
    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @MethodSource("provideShorterThan4CharactExpectedResult")
    public void testShorterThan4Charact(List givenValue, List expected){
        //Given

        //When
        FilterCollection filterCollection= new FilterCollection();
        //Then
        assertThat(filterCollection.filterToShorterThan4Characters(givenValue)).isEqualTo(expected);
    }

    static Stream<? extends Arguments> provideAreThereAdultsExpectedResult() {
        return Stream.of(
                Arguments.of(Person.createPersonsList(),true),
                Arguments.of(Person.createNoAdultsList(), false)
        );
    }

    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @MethodSource("provideAreThereAdultsExpectedResult")
    public static void areThereAdults(List givenValue, boolean expected) {
        FilterCollection filterCollection= new FilterCollection();
        //Then
        assertThat(filterCollection.areThereAdults(givenValue)).isEqualTo(expected);
    }

    @Test
    public void noAdultsTests() {
        //When
        FilterCollection filterCollection= new FilterCollection();
        //Then
        assertThat(filterCollection.noAdults(Person.createPersonsList())).isEqualTo(Boolean.FALSE);
        assertThat(filterCollection.noAdults(Person.createNoAdultsList())).isEqualTo(Boolean.TRUE);

    }

    public static List<String> firstThree(List<String> collection) {
        throw new UnsupportedOperationException("implement me");
    }
}

