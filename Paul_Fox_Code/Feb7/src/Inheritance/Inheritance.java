package Inheritance;

public class Inheritance {

    public static void main(String[] args) {

        Jedi k = new JediKnight();
        Jedi m = new JediMaster();
        Jedi p = new Padawan(m);

        p.setLightsaberColor(null);
        ((Padawan)p).setMaster(k);

        ((JediKnight)k).setMissionName("Misison 1");
        JediKnight t = (JediKnight)k;

        t.setMissionName("Mission 2");

        System.out.println(((JediKnight)k).getMissionName());
        System.out.println(t.getMissionName());

        rollCall(p);
        rollCall(k);
        rollCall(m);

        missionReport((JediKnight)k);
        missionReport(t);

        System.out.println(p instanceof Padawan);
        System.out.println(p instanceof Jedi);
        System.out.println(p instanceof JediKnight);


    }

    public static void rollCall(Jedi j) {

            System.out.println(j.getName());
    }

    public static void missionReport (JediKnight j) {

        System.out.println(j.getMissionName());

    }

}
