import model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {

        return collection.stream()
                .collect(Collectors.groupingBy(person->person.getAge()>40,Collectors.toList()));
    }



}

