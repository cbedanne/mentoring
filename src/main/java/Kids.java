import model.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Missk on 10/04/2017.
 */
public class Kids {

    public List<String> getKidNames(List<Person> collection) {

        return collection.stream().filter(person->person.getAge()<10).map(Person::getName).collect(Collectors.toList());

    }

}
