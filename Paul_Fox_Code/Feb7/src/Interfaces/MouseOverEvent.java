package Interfaces;

public interface MouseOverEvent {

    void fireEvent();

    default void log(){

        System.out.println("A mouseover event was fired");

    }

}
