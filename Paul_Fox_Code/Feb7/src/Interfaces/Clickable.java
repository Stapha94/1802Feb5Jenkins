package Interfaces;

public interface Clickable {

    void onClick();

    default void log(){

        System.out.println("A button was Clicked");

    }

}
