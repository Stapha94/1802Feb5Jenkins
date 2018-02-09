package com.anonymousclasses;

public class Button {
    ClickEvent e;

    public void subscribe(ClickEvent e) {
        this.e = e;
    }

    public void onClick() {
        if(e != null) {
            e.doEvent();
        }
    }
}
