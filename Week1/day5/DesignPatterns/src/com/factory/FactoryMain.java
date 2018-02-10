package com.factory;

public class FactoryMain {
    public static void main(String[] args) {
        StarFighterFactory.registerShip("xwing", XWing.class);
        StarFighterFactory.registerShip("tiefighter", TieFighter.class);

        try {
            XWing x = (XWing)StarFighterFactory.createStarFighter("xwing");
            TieFighter t = (TieFighter)StarFighterFactory.createStarFighter("tiefighter");
            System.out.println(x);
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Starfighter y = StarFighterFactory.createStarFighter("ywing");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
