import model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OldestPersonTest {
    @Test
    public void testOldestPerson(){
        //Given

        //When
        OldestPerson oldestPerson= new OldestPerson();
        //Then
        assertThat(oldestPerson.getOldestPerson(Person.createPersonsList())).isEqualTo("Jim");
    }

    @Test
    public void testOldestPersonForEachFirstLetter(){
        //Given

        //When
        OldestPerson oldestPerson= new OldestPerson();
        //Then
        assertThat(oldestPerson.getOldestPersonForEachFirstLetter(Person.createPersonsList()).get('J')).isEqualTo(Optional.of("Jim - 42"));


    }
}
