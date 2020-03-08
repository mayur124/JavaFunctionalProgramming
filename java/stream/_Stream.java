package stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Mayur", Gender.MALE),
                new Person("Nitesh", Gender.MALE),
                new Person("Nidhi", Gender.FEMALE),
                new Person("Disha", Gender.FEMALE)
        );

        /*people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);*/

        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.MALE);
        boolean containsAnyMale = people.stream().anyMatch(personPredicate);

        System.out.println(containsAnyMale);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
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

    enum Gender {MALE, FEMALE}
}
