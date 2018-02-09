package com.anonymousclasses;

public class AnonClasses {

    public static void main(String[] args) {
        Button b = new Button();
        ClickEvent e = new ClickEvent() {
            @Override
            public void doEvent() {
                System.out.println("Click event was triggered");
            }
        };

        b.subscribe(e);

        b.onClick();
    }
}
