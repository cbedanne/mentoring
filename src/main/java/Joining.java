import model.Person;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;


/**
 * Created by Missk on 10/04/2017.
 */
public class Joining {

    public String namesArrayToString(String... names) {
        return Arrays.stream(names).collect(joining(","));
    }

    public String namesToString(List<Person> collection) {
        return collection.stream().map(Person::getName).collect(joining(","));
    }

}
