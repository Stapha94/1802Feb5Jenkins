package FileIO.Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputMain {

    public static void main(String[] args) {

        ObjectInputStream inputStream = null;

        try{

            inputStream = new ObjectInputStream(new FileInputStream("sources/person"));
            Person p = (Person)inputStream.readObject();
            System.out.println(p);

        } catch (IOException e){

            e.printStackTrace();

        } catch (ClassNotFoundException e){

            e.printStackTrace();

        }


    }

}
