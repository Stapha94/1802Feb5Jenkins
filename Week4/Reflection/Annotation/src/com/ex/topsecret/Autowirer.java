package com.ex.topsecret;

import com.ex.annotations.Gimme;

import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by August Duet on 12/15/2016.
 */
public class Autowirer {

    List<Object> container = new ArrayList<>();

    public Autowirer(){
        Package p = this.getClass().getPackage();
        Set<Class<?>> classes = ClassDiscoverer.discover(p);
        doWiring(classes);

        for(final Object o : container){
            System.out.println(o.getClass().getName());
        }
    }

    private void doWiring(Set<Class<?>> classes){
        for(final Class c : classes) {
            Object parent = null;

            if(getClass().getName().equals(c.getName())){
                System.out.println("Skipping self instantiation");
                continue;
            }

            if(c.getName().equals(ClassDiscoverer.class.getName())){
                continue;
            }

            if(pruneClass(c)){
                continue;
            }

            try {
                System.out.println(String.format("Instantiating new object: %s", c.getName()));
                parent = instatiate(c);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


           System.out.println(String.format("Scanning class: %s", c.getName()));
           Method[] ms = c.getDeclaredMethods();

           for(final Method m : ms){
               Annotation[] annotations = m.getAnnotations();
               for(final Annotation a : annotations){
                   if(a instanceof Gimme){
                       Parameter param = m.getParameters()[0];
                       try {

                           System.out.println(String.format("-- Instantiating a new %s", param.getType().getName()));
                           Object o= instatiate(param.getType());
                           setParameter(parent, m, o);
                       } catch (ClassNotFoundException e) {
                           e.printStackTrace();
                       } catch (IllegalAccessException e) {
                           e.printStackTrace();
                       } catch (InstantiationException e) {
                           e.printStackTrace();
                       } catch (InvocationTargetException e) {
                           e.printStackTrace();
                       } catch (NoSuchMethodException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
       }
    }

    private void setParameter(Object o, Method m, Object param) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        m.invoke(o, param);
    }

    private boolean pruneClass(Class c){

        for(final Object o : container){
            if(o.getClass().getName().equals(c.getName())){
                return true;
            }
        }
        return false;
    }

    private Object instatiate(Class c) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object o = Class.forName(c.getName()).newInstance();
        container.add(o);
        return o;
    }

    public Object getGimme(Class clazz){
        for(final Object o : container){
            if(o.getClass().equals(clazz)){
                return o;
            }
        }
        return null;
    }
}
