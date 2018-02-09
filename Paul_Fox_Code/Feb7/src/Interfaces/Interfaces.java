package Interfaces;

public class Interfaces {

    public static void main(String[] args) {

        Button b = new Button();
//        ClickEvent ce = new LeftMouseClick();
//        b.subscribe(ce);

        b.subscribe((x) -> {

            System.out.println("Lambda Function fired by " + x);

        });

        b.onClick();

    }

}
