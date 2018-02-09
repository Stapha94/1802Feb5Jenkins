package com.inheritance;

public class JediKnight extends Jedi {

    private String missionName;

    public JediKnight() {}

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
}
