package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Mayur", Gender.MALE),
                new Person("Nitesh", Gender.MALE),
                new Person("Nidhi", Gender.FEMALE),
                new Person("Disha", Gender.FEMALE)
        );

        // Imperative approach
        System.out.println("// Imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.gender == Gender.FEMALE) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("// Declarative approach");
        List<Person> females2 = people.stream()
                .filter(person -> person.gender == Gender.FEMALE)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
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
