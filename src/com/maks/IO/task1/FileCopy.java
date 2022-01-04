package com.maks.IO.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(final String[] args) {

        try (final FileInputStream fileIn = new FileInputStream("src/com/maks/IO/task1/files/fileInput");
             final FileOutputStream fileOut = new FileOutputStream("src/com/maks/IO/task1/files/fileOutput")) {

            int a;
            while ((a = fileIn.read()) != -1) {
                fileOut.write(a);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
