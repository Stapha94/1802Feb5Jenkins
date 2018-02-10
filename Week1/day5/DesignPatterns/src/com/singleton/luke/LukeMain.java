package com.singleton.luke;

public class LukeMain {
    public static void main(String[] args) {
        LukeSkywalker luke = LukeSkywalker.LUKE_SKYWALKER;
        luke.loseHand();
        System.out.println(luke.getTitle());
    }
}
