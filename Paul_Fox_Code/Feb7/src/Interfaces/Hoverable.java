package Interfaces;

public interface Hoverable {

    void onHover();

    default void log(){

        System.out.println("A button was hovered over");

    }

}
