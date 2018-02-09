package Interfaces;

public class LeftMouseClick implements ClickEvent {

    @Override
    public void fireEvent(String targetName){

        System.out.println("A Click event was fired");

    }

}
