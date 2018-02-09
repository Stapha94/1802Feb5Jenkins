package com.interfaces;

public class Button implements Clickable, Hoverable {
    ClickEvent e;
    @Override
    public void onClick() {
        if( this.e != null) {
            this.log();
            e.fireEvent("clickable button");
        }
    }

    @Override
    public void log() {
        System.out.println("A button event was fired");
    }

    public void subscribe(ClickEvent e) {
        this.e = e;
    }

    @Override
    public void onHover() {

    }
}
