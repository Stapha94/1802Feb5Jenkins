package com.ex.container.HandlerMapper;

import com.ex.container.servlet.Dispatcher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by August Duet on 6/6/2017.
 */
public class HandlerMapper {

    private static Map<String, Mapping> mappings = new HashMap<>();

    public static void doMappings(String contextFile) throws JAXBException, ClassNotFoundException, FileNotFoundException {
        Controllers controllers = new Controllers();
        //find the context and unmarshall the controllers
        JAXBContext context = JAXBContext.newInstance(Controllers.class);
        Unmarshaller um = context.createUnmarshaller();
        String filepath = Dispatcher.class.getClassLoader().getResource("/"+contextFile).getFile().substring(1);
        System.out.println(filepath);
        controllers = (Controllers) um.unmarshal(new FileReader(filepath));

        for (final Controller c : controllers.getControllerList()) {
            String path = c.getPath();
            for (Handler h : c.getHandlerList()) {
                String k = "";
                if(h.getPath() != null){
                    k += path + h.getPath();
                }else{
                    k += path;
                }
                k += "," + h.getMethod().toUpperCase();
                Mapping m = new Mapping();
                m.setClazz(Class.forName(c.getClazz()));
                m.setHandle(h.getHandle());
                mappings.put(k, m);
            }
        }

        for (final Map.Entry<String, Mapping> e : mappings.entrySet()) {
            System.out.println(e.getKey() + " mapped to " + e.getValue().getHandle());
        }
    }

    public static Mapping getMapping(String path, String method){
        String k = path + "," + method;
        return mappings.get(k);
    }
}
