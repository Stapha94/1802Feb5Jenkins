package com.abstractclasses;

public abstract class Bicycle {
    protected float velocity;
    protected int height;

    public abstract void go();
    public void brake(){

    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
