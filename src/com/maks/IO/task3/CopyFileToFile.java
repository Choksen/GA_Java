package com.maks.IO.task3;

import java.io.*;

public class CopyFileToFile {

    public static void copyFile(final File fileInput, final File fileOutput) {
        try (final FileReader reader = new FileReader(fileInput);
             final FileWriter writer = new FileWriter(fileOutput)) {

            int symbol;
            while ((symbol = reader.read()) != -1) {
                writer.write(symbol);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void copyBufferedFile(final File fileInput, final File fileOutput) {
        try (final BufferedReader reader = new BufferedReader(new FileReader(fileInput));
             final BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

