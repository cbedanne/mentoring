import model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class FilterCollection {

    public static List<String> filterToShorterThan4Characters(List<String> collection) {
        return collection.stream().filter(str->str.length()<4).collect(Collectors.toList());
    }

    public static boolean areThereAdults(List<Person> collection) {
        return collection.stream().anyMatch(person->person.getAge()>18);
    }

    public boolean noAdults(List<Person> collection) {
        Boolean result= collection.stream().noneMatch(person->person.getAge()>18);
        return result;

    }

    public static List<String> firstThree(List<String> collection) {
        throw new UnsupportedOperationException("implement me");
    }
}

