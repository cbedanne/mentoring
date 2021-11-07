import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTests {

    @Test
    public void testlettercountForNamesGreaterThan5(){
        //Given

        //When
        Names names= new Names();
        //Then
        assertThat(names.lettercountForNamesGreaterThan5("Johnny","Peter","Jim","Christophe")).isEqualTo(16);
    }

    @Test
    public void testgetIntegerAsOddEvenString(){
        //When
        Names names= new Names();
        //Then
        assertThat( names.getIntegerAsOddEvenString(Arrays.asList(1, 4, 9, 10, 3))).isEqualTo("o1,e4,o9,e10,o3");

    }
}
