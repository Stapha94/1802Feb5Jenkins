package QTwenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileReading {

    public static void main(String[] args) throws IOException {

        BufferedReader myBReader = null;

        try {

            myBReader = new BufferedReader(new FileReader("resources/Data.txt"));
            String line;

            while((line = myBReader.readLine()) != null){

                String[] data = line.split(":");
                System.out.println("Name: " + data[0] + " " + data[1] + "\nAge " + data[2] + " Years\nState: " + data[3] + " State");
                System.out.println();

            }

        } catch (FileNotFoundException e){

            e.printStackTrace();

        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (myBReader != null){

                myBReader.close();

            }

        }


    }

}
