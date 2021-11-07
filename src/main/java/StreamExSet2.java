import model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class StreamExSet2 {

    public List<String> toUpperCase(List<String> collection) {
        return collection.stream()
                .map(String::toUpperCase)
                .collect(toList());
    }


    public List<String> flatCollection(List<List<String>> collection) {
        //                collection.stream()
//                        .collect(ArrayList::new, List::addAll, List::addAll);
        return collection.stream()
            .flatMap(List::stream)
            .collect(toList());
    }

    public Map<String, List<String>> groupByNationality(List<Person> collection) {
        return collection.stream()
                .collect(Collectors.
                        groupingBy(Person::getNationality,mapping(Person::getName,Collectors.toList())));
    }




}


