package com.singleton.singletondeathstar;

public class DeathstarMain {

    public static void main(String[] args) {
        DeathStar ds = DeathStar.getInstance();
        DeathStar ds2 = DeathStar.getInstance();

        ds.deployFighters(10);
        System.out.printf("ds has %d deployed fighters.\n", ds.getDeployedStarFighters());

        ds2.deployFighters(5);
        System.out.printf("ds has %d deployed fighters.\n", ds.getDeployedStarFighters());
        System.out.printf("ds2 has %d deployed fighters.\n", ds2.getDeployedStarFighters());
    }
}
