package FileIO.writing;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileWriter;
import java.io.IOException;

public class WritingMain {

    public static void main(String[] args) throws IOException {

        FileWriter myWriter = null;

        try{

            myWriter = new FileWriter("sources/data");
            myWriter.write("Paul:23\nJohn:22\nErica:40");

        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (myWriter != null){

                myWriter.close();

            }

        }


    }

}
