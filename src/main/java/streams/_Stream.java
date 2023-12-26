package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

        boolean containsAnyFemales = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsAnyFemales);

        boolean containsNoneFemales = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsNoneFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
