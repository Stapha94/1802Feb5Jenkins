package comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.setName("August");
        p1.setAge(35);

        p2.setName("John");
        p2.setAge(22);

        if(p1.compareTo(p2) > 0) {
            System.out.println(p1.getName() + " is older than " + p2.getName());
        }

        List<Person> people = Arrays.asList(p1, p2);
        System.out.println("Before sorting");
        for(Person p : people) {
            System.out.println(p);
        }

        System.out.println("\nAfter sorting");
        Collections.sort(people);
        for(Person p : people) {
            System.out.println(p);
        }

        List<Person> newPeople = Arrays.asList(p1, p2);
        System.out.println("\nBefore sorting");
        for(Person p : newPeople) {
            System.out.println(p);
        }

        System.out.println("\nAfter sorting");
        Collections.sort(newPeople, new PersonAgeCompartor());
        for(Person p : newPeople) {
            System.out.println(p);
        }
    }
}
