package com.fileio.writing;

import java.io.FileWriter;
import java.io.IOException;

public class WritingMain {
    public static void main(String[] args) throws IOException {
        FileWriter writer = null;

        try {
            writer = new FileWriter("resources/data");
            writer.write("August:35\nJohn:22\nErica:40");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}
