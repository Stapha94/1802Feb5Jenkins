package com.singleton.singletondeathstar;

public class DeathStarMain {

    public static void main(String[] args) {

        DeathStar ds = DeathStar.getInstance();
        DeathStar ds2 = DeathStar.getInstance();

        ds.deployFighters(10);

        System.out.printf("Death Star has %d deployed fighters.\n", ds.getDeployedStarFighters());

        ds.deployFighters(5);
        System.out.printf("Death Star has %d deployed fighters.\n", ds.getDeployedStarFighters());
        System.out.printf("Death Star 2 has %d deployed fighters.\n", ds2.getDeployedStarFighters());

    }

}
