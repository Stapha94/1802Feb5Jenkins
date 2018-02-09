package com.inheritance;

public class Inheritance {

    public static void main(String[] args) {
        Jedi k = new JediKnight();
        Jedi m = new JediMaster();
        Jedi p = new Padawan(m);

        k.setName("Leia Organa Solo");
        m.setName("Luke Skywalker");
        p.setName("Joe");

        p.setLightsaberColor(null);
        ((Padawan)p).setMaster(k);

        ((JediKnight)k).setMissionName("Mission 1");
        JediKnight t = (JediKnight)k;

        System.out.println(((JediKnight) k).getMissionName());
        System.out.println(t.getMissionName());

        System.out.println();

        t.setMissionName("Mission 2");

        System.out.println();
        System.out.println(((JediKnight) k).getMissionName());
        System.out.println(t.getMissionName());
        System.out.println();

        roleCall(p);
        roleCall(k);
        roleCall(m);

        System.out.println();

        //missionReport((JediKnight)p);
        missionReport((JediKnight)k);
        missionReport(t);
        System.out.println();

        System.out.println("Is p a Padawan? " + (p instanceof Padawan));
        System.out.println("Is p a Jedi? " + (p instanceof Jedi));
        System.out.println("Is p a JediKnight? " + (p instanceof JediKnight));
    }

    public static void roleCall(Jedi j){
        System.out.println(j.getName());
    }

    public static void missionReport(JediKnight j) {
        System.out.println(j.getMissionName());
    }
}
