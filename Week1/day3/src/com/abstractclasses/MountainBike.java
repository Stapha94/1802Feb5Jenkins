package com.abstractclasses;

public class MountainBike extends Bicycle {
    private int numGears;
    private float gearRatio;
    private int currentGear;

    public MountainBike() {}

    @Override
    public void go() {

    }

    public int getNumGears() {
        return numGears;
    }

    public void setNumGears(int numGears) {
        this.numGears = numGears;
    }

    public float getGearRatio() {
        return gearRatio;
    }

    public void setGearRatio(float gearRatio) {
        this.gearRatio = gearRatio;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public void upShift(){
    }

    public void downShift() {

    }
}
