package AbstractClasses;

public class MountainBike extends Bicycle {

    private int numGears;
    private float gearRatio;
    private int currentGear;

    public MountainBike() {}

    @Override
    public void go(){



    }

    public int getNumGears() {

        return numGears;

    }

    public float getGearRatio() {

        return gearRatio;

    }

    public int getCurrentGear() {

        return currentGear;

    }

    public void setNumGears(int numGears) {

        this.numGears = numGears;

    }

    public void setGearRatio(float gearRatio) {

        this.gearRatio = gearRatio;

    }

    public void setCurrentGear(int currentGear) {

        this.currentGear = currentGear;

    }

}
