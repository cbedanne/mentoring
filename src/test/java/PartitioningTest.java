import model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


public class PartitioningTest {

    private static final Person SARA_KID4 = Person.aPerson("Sara", 4);
    private static final Person VIKTOR_ADULT40 = Person.aPerson("Viktor", 40);
    private static final Person EVA_ADULT_40 = Person.aPerson("Eva", 42);

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        List<Person> kidsAndAdults = Person.createPersonsList();

        Map<Boolean, List<Person>> result = Partitioning.partitionAdults(kidsAndAdults);

        assertThat(result.get(Boolean.TRUE).contains(kidsAndAdults.get(2)));
        assertThat(result.get(Boolean.FALSE).contains(kidsAndAdults.get(0)));
        assertThat(result.get(Boolean.FALSE).contains(kidsAndAdults.get(1)));
        assertThat(result.get(Boolean.FALSE).contains(kidsAndAdults.get(3)));
    }
}

