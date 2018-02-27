package com.ex.topsecret;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by August Duet on 12/15/2016.
 */
public class ClassDiscoverer {
    private ClassDiscoverer(){}

    public static Set<Class<? extends Object>> discover(Package p){
        System.out.println(String.format("Class discovery package: %s", p.toString()));

        String packageRelPath = getRelPath(p.getName());
        String fullPath;
        File dir = null;
        System.out.println(String.format("Package translated to relative path: %s", packageRelPath));

        URL resource = ClassLoader.getSystemClassLoader().getResource(packageRelPath);
        if(resource == null){
            throw new RuntimeException(String.format("No resources found at: %s", packageRelPath));
        }
        System.out.println(String.format("Class discovery resource: %s", resource));
        fullPath = resource.getFile();
        System.out.println(String.format("Scanning directory: %s", fullPath));

        try{
            dir = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Discovery directory: %s", dir));

        if(dir != null && dir.exists()){
            String[] files = dir.list((File d, String n) ->{
                if(n.endsWith(".class")){
                    return true;
                }
                return false;
            });

            Set<Class<? extends Object>> classes = new HashSet<>();
            System.out.println("------FOUND------");
            for(String s : files){
                String className = p.getName() + "." + s.substring(0, s.length() - 6);
                System.out.println(className);

                try{
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException e) {
                    System.out.println(String.format("Error loading class: %s", className));
                }
            }
            System.out.println("-----------------");
            return classes;
        }
        return null;
    }

    private static String getRelPath(String pName){
        String relPath = pName.replace(".", "/");
        return relPath;
    }
}
