import model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by Missk on 10/04/2017.
 */
public class OldestPerson {

    public String getOldestPerson(List<Person> persons) {

        return persons.stream().max(Person::ageDifference).map(Person::getName).orElse("No person available");

    }

    public Map<Character, Optional<Person>> getOldestPersonForEachFirstLetter(List<Person> persons){

        Map<Character, Optional<Person>> result= persons.stream()
                .collect(groupingBy(p->p.getName().charAt(0),
                        reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        return result;
    }
}

