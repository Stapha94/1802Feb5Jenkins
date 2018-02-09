package com.fileio.reading;

import com.fileio.Person;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputMain {
    public static void main(String[] args) {
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("resources/person"));
            Person p = (Person)in.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
