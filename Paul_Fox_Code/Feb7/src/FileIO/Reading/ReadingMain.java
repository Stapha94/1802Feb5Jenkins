package FileIO.Reading;

import java.io.*;

public class ReadingMain {

    public static void main(String[] args) throws IOException {

        BufferedReader myReader = null;

        try{

            myReader = new BufferedReader((new FileReader("sources/data")));
            String line;
            int count = 0;

            while((line = myReader.readLine()) != null){

                count++;
                String[] data = line.split(":");
                System.out.println(data[0] + " is " + data[1] + " years old");

            }

            System.out.println(count + " lines read");

        } catch (FileNotFoundException e){

            e.printStackTrace();

        } catch (IOException e){

            e.printStackTrace();

        } finally {

            if (myReader != null){

                myReader.close();

            }

        }

    }

}
