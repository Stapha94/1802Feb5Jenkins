package Interfaces;

public class Button implements Clickable, Hoverable{

    ClickEvent e;

    public void subscribe(ClickEvent e){

        this.e = e;

    }

    public void onClick(){

        if (e != null) {

            e.fireEvent("clickable button");
            this.log();

        }

    }

    @Override
    public void onHover(){



    }

    @Override
    public void log(){

        System.out.println("A buton event was fired");

    }

}
