package com.maks.IO.task4;

import java.io.File;
import java.util.Objects;

public class viewingDirectory {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void printDir(final File fileOrDir) {
        for (final File file : Objects.requireNonNull(fileOrDir.listFiles())) {
            if (file.isDirectory()) {
                System.out.println(file.getName() + " : directory");
                printDir(file);
            } else if (file.isFile()) {
                System.out.println(ANSI_GREEN + file.getName() + " : file" + ANSI_RESET);
            } else {
                System.out.println(file.getName() + " : unknown");
            }
        }
    }
}
