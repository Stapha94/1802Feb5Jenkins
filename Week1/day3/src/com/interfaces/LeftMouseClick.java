package com.interfaces;

public class LeftMouseClick implements ClickEvent {
    @Override
    public void fireEvent(String targetName) {
        System.out.println("The left mouse button was clicked");
    }
}
