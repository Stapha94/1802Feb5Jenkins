package com.rawtypes;

import java.util.*;

public class RawMain {
    static List numbers = new ArrayList();
    static Set names = new HashSet();
    static Map people = new HashMap();

    public static void main(String[] args) {
        numbers.add(1);
        numbers.add("1");
        numbers.add(true);
        numbers.add(new Object());

        names.add("Andy");
        names.add("John");
        names.add("Andy");

        people.put(10, "August");
        people.put(66, "Erica");
        people.put("Carla", 12);

    }
}
