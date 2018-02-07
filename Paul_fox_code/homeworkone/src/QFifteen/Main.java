package QFifteen;

public class Main {

    public static void main(String[] args) {

        Functionality f = new Functionality();
        int x = 5;
        int y = 3;

        System.out.println("Adding " + x + " and " + y + ": " + f.add(x, y));
        System.out.println("Subtracting " + x + " and " + y + ": " + f.subtract(x, y));
        System.out.println("Multiplying " + x + " and " + y + ": " + f.multiply(x, y));
        System.out.println("Dividing " + x + " and " + y +  ": " + f.divide((float)x, (float)y));


    }

}
