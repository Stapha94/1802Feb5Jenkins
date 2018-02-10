package com.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class StarFighterFactory {

    private static Map<String, Class> ships = new HashMap<>();

    public static void registerShip(String id, Class clazz) {
        ships.put(id, clazz);
    }

    public static Starfighter createStarFighter(String fighterId) throws Exception {
        Class clazz = ships.get(fighterId);
        Constructor def = clazz.getConstructor(null);

        if(clazz == null) {
            throw new Exception("This factory doesn't make those types of star fighters " + fighterId);
        }

        return (Starfighter)def.newInstance(null);
    }
}
