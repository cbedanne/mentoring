import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamEx1Test {

    static class StreamEx1ArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(6, 21),
                    Arguments.of(5, 15)
            );
        }
    }

    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @ArgumentsSource(StreamEx1ArgumentProvider.class)
    public void testSumFrom1(int givenValue, int expectedResult){
        //Given

        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getSumFrom1(givenValue)).isEqualTo(expectedResult);    }


    @Test
    public void whenValueis6ThenSumFrom1equal21(){
        //Given
        int givenValue = 6;
        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getSumFrom1(givenValue)).isEqualTo(21);
    }

    @Test
    public void whenValueis5ThenSumFrom1equal15(){
        //Given
        int givenValue = 5;
        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getSumFrom1(givenValue)).isEqualTo(15);
    }

    static class StreamEx2ArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, 5),
                    Arguments.of(3, 14),
                    Arguments.of(5, 55),
                    Arguments.of(10,385)
            );
        }
    }

    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @ArgumentsSource(StreamEx2ArgumentProvider.class)
    public void testSumOfSquareFrom1(int givenValue, int expectedResult){
        //Given

        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getSumOfSquareFrom1(givenValue)).isEqualTo(expectedResult);
    }

    static class StreamEx3ArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, 2),
                    Arguments.of(3, 2),
                    Arguments.of(5, 6),
                    Arguments.of(10,30)
            );
        }
    }

    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @ArgumentsSource(StreamEx3ArgumentProvider.class)
    public void testSumOfEvenFrom1(int givenValue, int expectedResult){
        //Given

        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getSumOfEvenFrom1(givenValue)).isEqualTo(expectedResult);
    }

    static class StreamEx4ArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, 2, 1),
                    Arguments.of(3, 2, 4),
                    Arguments.of(5, 6, 9),
                    Arguments.of(6,12, 9)
            );
        }
    }

    @ParameterizedTest(name = "{index} => givenValue={0}, expectedEvenResult={1}, expectedOddResult={2}")
    @ArgumentsSource(StreamEx4ArgumentProvider.class)
    public void testSumOfEvenAndOddFrom1(int givenValue, int expectedEvenSum, int expectedOddSum){
        //Given

        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getSumOfEvenAndOddFrom1(givenValue).get(Boolean.TRUE)).isEqualTo(expectedEvenSum);
        assertThat(streamEx.getSumOfEvenAndOddFrom1(givenValue).get(Boolean.FALSE)).isEqualTo(expectedOddSum);
    }


    @ParameterizedTest(name = "{index} => givenValue={0}, expectedResult={1}")
    @MethodSource("provideFacteursPremiersExpectedResults")
    public void testgetFacteursPremiers(int givenValue,List expected){
        //Given

        //When
        StreamExSet1 streamEx= new StreamExSet1();
        //Then
        assertThat(streamEx.getFacteursPremiers(givenValue)).isEqualTo(expected);
    }

    static Stream<? extends Arguments> provideFacteursPremiersExpectedResults() {
        return Stream.of(
                Arguments.of(6,Arrays.asList(2,3)),
                Arguments.of(11,Arrays.asList(11)),
                Arguments.of(24,Arrays.asList(2,2,2,3)),
                Arguments.of(124,Arrays.asList(2,2,31))
        );
    }
}
