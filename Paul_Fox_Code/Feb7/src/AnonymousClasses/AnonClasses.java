package AnonymousClasses;

public class AnonClasses {

    public static void main(String[] args) {

        Button b = new Button();

        b.subscribe(new ClickEvent() {

            @Override
            public void doEvent() {

                System.out.println("Click Event was Triggered");

            }

        });

        b.onClick();

    }
}
