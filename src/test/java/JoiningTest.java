import model.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JoiningTest {

    @Test
    public void testNamesArrayToString(){
        //Given

        //When
        Joining joining= new Joining();
        //Then
        assertThat(joining.namesArrayToString("John","Peter","Jim")).isEqualTo("John,Peter,Jim");
    }

    @Test
    public void testNamesToString(){
        //Given

        //When
        Joining joining= new Joining();
        //Then
        assertThat(joining.namesToString(Person.createPersonsList())).isEqualTo("Tom,Franck,Jim,Joe,André");
    }
}
