package com.fileio.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("resources/data"));
            String line;
            int count = 0;

            while((line = reader.readLine()) != null) {
                count++;
                String[] data = line.split(":");
                System.out.println(data[0] + " is " + data[1] + " years old");
            }
            System.out.println(count + " lines read");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                reader.close();
            }
        }
    }
}
