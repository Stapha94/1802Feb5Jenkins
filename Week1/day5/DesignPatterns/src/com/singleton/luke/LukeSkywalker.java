package com.singleton.luke;

public enum LukeSkywalker {
    LUKE_SKYWALKER("Grandmaster Jedi");

    private String title;

    LukeSkywalker(){}
    LukeSkywalker(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void loseHand() {
        System.out.println("Ouch");
    }
}
