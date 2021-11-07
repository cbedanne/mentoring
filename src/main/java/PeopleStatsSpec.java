import model.Person;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Missk on 10/04/2017.
 */
public class PeopleStatsSpec {
    public static IntSummaryStatistics getStats(List<Person> collection) {

        return collection.stream().collect(Collectors.summarizingInt(Person::getAge));

    }

}

