package com.generics;

import java.util.*;

public class GenericCollectionsMain {

    static List<Integer> numbers = new ArrayList<>();
    static Set<String> names = new HashSet<>();
    static Map<Integer, String> people = new HashMap<>();

    public static void main(String[] args) {

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        names.add("Andy");
        names.add("John");
        names.add("Andy");

        people.put(10, "Paul");
        people.put(66, "John");
        people.put(12, "Carla");

        System.out.println("Print Numbers");

        for(Integer i: numbers){

            System.out.println(i);

        }

        System.out.println("With an iterator now");

        Iterator itr = numbers.iterator();

        while(itr.hasNext()){

            Integer i = (Integer)itr.next();
            System.out.println(i);
            itr.remove();

        }

        System.out.println("After the Iterator");

        for(Integer i: numbers){

            System.out.println(i);

        }

        System.out.println("Iterate of the map's entry set");
        for(Map.Entry<Integer, String> entry: people.entrySet()){

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

    }


}
