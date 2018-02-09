package com.factory;

import java.util.HashMap;
import java.util.Map;

public class StarFighterFactory {

    private static Map<String, Class> ships = new HashMap<>();

    public static void registerShip(String id, Class clazz){

        ships.put(id, clazz);

    }

    public static StarFighter createStarFighter(String fighterID) throws Exception{

        Class clazz = ships.get(fighterID);

        if(clazz == null){

            throw new Exception("This factory doesn't make those types of star fighters" + fighterID);

        }

        return (StarFighter)clazz.newInstance();

    }

}
