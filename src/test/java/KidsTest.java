import model.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KidsTest {

    @Test
    public void testGetKidsName(){
        //Given

        //When
        Kids kids= new Kids();
        //Then
        assertThat(kids.getKidNames(Person.createPersonsList())).contains("André");
        assertThat(kids.getKidNames(Person.createPersonsList())).doesNotContain("Jim","Franck","Tom");
    }
}
