import comparing.Person;

public class EqualsMain {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.setName("August");
        p1.setAge(35);

        p2.setName("August");
        p2.setAge(35);

        if(p1.equals(p2)) {
            System.out.println("P1 and P2 are equal");
        } else {
            System.out.println("P1 and P2 are not equal");
        }
    }
}
