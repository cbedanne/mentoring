package model;

import java.util.Arrays;
import java.util.List;

public class Person {
    private final String name;
    private final int age;
    private String nationality;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public static Person aPerson(String name, int age) {
        return new Person(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public int ageDifference(final Person otherPerson){
        return age- otherPerson.age;
    }

    public String toString(){
        return String.format("%s - %d", name, age);
    }

    public static List<Person> createPersonsList(){
        return Arrays.asList(
                new Person ("Tom", 19, "BE"),
                new Person ("Franck", 17,"BE"),
                new Person ("Jim", 42, "FR"),
                new Person ("Joe", 41, "FR"),
                new Person ("André", 5,"UK"));
    }

    public static List<Person> createNoAdultsList(){
        return Arrays.asList(
                new Person ("Tom", 15, "BE"),
                new Person ("Franck", 17,"BE"),
                new Person ("Jim", 14, "FR"),
                new Person ("André", 5,"UK"));
    }
}
