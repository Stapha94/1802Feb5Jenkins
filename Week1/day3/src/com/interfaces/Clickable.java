package com.interfaces;

public interface Clickable {
    void onClick();

    default void log() {
        System.out.println("A click event was fired");
    }
}
