package FileIO.Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputMain {

    public static void main(String[] args) {

        ObjectOutputStream outputStream = null;
        Person p = new Person();

        p.setName("Paul Fox");
        p.setAge(23);
        p.setSSN("111-11-1111");

        try {

            outputStream = new ObjectOutputStream(new FileOutputStream("sources/person"));
            outputStream.writeObject(p);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
