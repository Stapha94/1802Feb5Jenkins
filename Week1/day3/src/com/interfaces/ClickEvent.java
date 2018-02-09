package com.interfaces;

@FunctionalInterface
public interface ClickEvent {
    void fireEvent(String targetName);
}
