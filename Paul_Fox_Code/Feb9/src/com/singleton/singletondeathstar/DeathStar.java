package com.singleton.singletondeathstar;

public class DeathStar {

    //Provide a private constructor to prevent instantiation
    private DeathStar(){



    }

    private static DeathStar instance = new DeathStar();

    private int deployedStarFighters = 0;

    public static DeathStar getInstance(){

        if(instance == null){

            instance = new DeathStar();

        }
        return instance;

    }

    public void deployFighters(int howMany){

        deployedStarFighters += howMany;
        System.out.printf("Deploying %d Tie Fighters.\n", deployedStarFighters);

    }

    public int getDeployedStarFighters(){

        return deployedStarFighters;

    }

}
