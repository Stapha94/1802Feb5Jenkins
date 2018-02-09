package com.inheritance;

public class Padawan extends Jedi {

    private Jedi master;

    public Padawan() {}

    public Padawan(Jedi master) {
        this.master = master;
    }

    public Jedi getMaster() {
        return master;
    }

    public void setMaster(Jedi master) {
        this.master = master;
    }
}
