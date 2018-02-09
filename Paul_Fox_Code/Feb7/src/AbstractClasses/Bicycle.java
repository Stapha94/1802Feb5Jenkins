package AbstractClasses;

public abstract class Bicycle {

    private float velocity;
    private float height;

    public abstract void go();
    public void brake(){



    }

    public float getVelocity() {

        return velocity;

    }

    public float getHeight() {

        return height;

    }

    public void setVelocity(float velocity) {

        this.velocity = velocity;

    }

    public void setHeight(float height) {

        this.height = height;

    }
}
