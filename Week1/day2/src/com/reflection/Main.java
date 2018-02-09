package com.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@AuthorNotes(author = "August Duet", comment = "I created this class for some reason")
public class Main {
    private String message = "Hello, World!";
    public Boolean active = false;
    protected int data = 10;

    public static void main(String[] args) {
        new Main().reflectOnMe();
        new Main().invokeMethod("printMessage");
        new Main().getFields();
    }

    public void reflectOnMe() {
        Class c = this.getClass();
        Annotation[] annotations = c.getAnnotations();

        for(final Annotation a : annotations) {
            if(a instanceof AuthorNotes) {
                AuthorNotes notes = (AuthorNotes)a;
                System.out.println("This class was written by " + notes.author());
                System.out.println("With the comments:\n --- " + notes.comment());
            }
        }
    }

    public void invokeMethod(String name) {
        Class c = this.getClass();

        try{
            Method m = c.getMethod(name, null);
            m.invoke(this, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void getFields() {
        Class c = this.getClass();

        Field[] fields = c.getDeclaredFields();
        for(Field f : fields) {
            System.out.println(f.getName());
        }
    }

    public void printMessage() {
        System.out.println(message);
    }
}
