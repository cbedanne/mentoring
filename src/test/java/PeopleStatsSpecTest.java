import model.Person;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PeopleStatsSpecTest {

    @Test
    public void getStatsShouldReturnAverageAge() {
        assertThat(PeopleStatsSpec.getStats(Person.createPersonsList()).getAverage()).isEqualTo((double)(19 + 17 + 41 +42+ 5) / 5);
    }

    @Test
    public void getStatsShouldReturnNumberOfPeople() {
        assertThat(PeopleStatsSpec.getStats(Person.createPersonsList()).getCount()).isEqualTo(5L);
    }

    @Test
    public void getStatsShouldReturnMaximumAge() {
        assertThat(PeopleStatsSpec.getStats(Person.createPersonsList()).getMax()).isEqualTo(42);
    }

    @Test
    public void getStatsShouldReturnMinimumAge() {
        assertThat(PeopleStatsSpec.getStats(Person.createPersonsList()).getMin()).isEqualTo(5);
    }

    @Test
    public void getStatsShouldReturnSumOfAllAges() {
        assertThat(PeopleStatsSpec.getStats(Person.createPersonsList()).getSum()).isEqualTo(19L + 17L + 41L + 42L+5L);
    }


}

