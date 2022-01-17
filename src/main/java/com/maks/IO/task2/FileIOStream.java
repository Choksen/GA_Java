package com.maks.IO.task2;

import java.io.*;

public class FileIOStream {
    public static void main(String[] args) {
        try (final FileInputStream input = new FileInputStream("src/com/maks/IO/task2/files/fileInput");
             final OutputStream output = new FileOutputStream("src/com/maks/IO/task2/files/fileOutput")) {

            final char[] symbols = {'a', 'b', 'c'};
            for (final char symbol : symbols) {
                // Запись каждого символа в текстовый файл
                output.write(symbol);
            }

            final int size = input.available();

            for (int i = 0; i < size; i++) {
                // Чтение текстового файла посимвольно
                System.out.print((char) input.read() + " ");
            }
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}
