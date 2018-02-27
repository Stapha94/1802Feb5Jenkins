package com.ex;

import com.ex.annotations.Custom;
import com.ex.topsecret.Autowirer;
import com.ex.topsecret.TestClass;
import com.ex.topsecret.TestClass2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Custom(author = "August Duet", comment = "This is a custom annotation example")
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //new Main().reflectionOnMe();

        //new Main().reflectOn(Person.class);

        Autowirer aw = new Autowirer();

        TestClass2 t = (TestClass2) aw.getGimme(TestClass2.class);

        t.doSomething();
    }

    public void print(){
        System.out.println("I am printing this string");
    }


    public void reflectionOnMe(){
        Class c = this.getClass();
        Annotation[] annotations = c.getAnnotations();

        for(final Annotation a : annotations){
            if(a instanceof Custom){
                Custom customAnnotation = (Custom)a;
                System.out.println("This class was written by:\n --- " + customAnnotation.author());
                System.out.println("With the comment:\n --- " + customAnnotation.comment());
            }
        }
    }
    public void reflectOn(Class clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Field[] fields = clazz.getFields();
        Constructor noArgs = clazz.getConstructor(null);
        Method[] methods = clazz.getMethods();

//        System.out.println(clazz.getName() + "has a default constuctor call " + noArgs.getName());
//        System.out.println();
//
//        if(fields.length > 0){
//            System.out.println(clazz.getName() + " has these visible fields");
//            for(Field f : fields){
//                System.out.println(f.getName());
//            }
//        }else{
//            System.out.println(clazz.getName() + " has no visible fields");
//        }
//
//        System.out.println();
//        fields = clazz.getDeclaredFields();
//        if(fields.length > 0){
//            System.out.println(clazz.getName() + " has these declared fields");
//            for(Field f : fields){
//                System.out.println(f.getName());
//            }
//        }else{
//            System.out.println(clazz.getName() + " has no declared fields");
//        }
//
//        System.out.println();
//        if(methods.length > 0){
//            System.out.println(clazz.getName() + " has these visible methods");
//            for(Method m : methods){
//                System.out.println(m.getName());
//            }
//        }else{
//            System.out.println(clazz.getName() + " has no visible methods");
//        }

        Object o = clazz.newInstance();
        Method setName = clazz.getMethod("setUsername", String.class);
        Method getName = clazz.getMethod("getUsername", null);

        System.out.println();
        System.out.println("Setting username");
        setName.invoke(o, "August");

        System.out.println("username is: " + getName.invoke(o, null));
    }
}
