package com.maks.IO;

import com.maks.IO.task3.CopyFileToFile;
import com.maks.IO.task4.ViewingDirectory;
import com.maks.IO.task5.Report;
import com.maks.IO.task5.Staff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        //task3
        File fileInput = new File("src/com/maks/IO/task3/files/fileInput");
        File fileOutput = new File("src/com/maks/IO/task3/files/fileOutput");

        double startTime = System.nanoTime();
        CopyFileToFile.copyFile(fileInput, fileOutput);
        double finishTime = System.nanoTime();
        System.out.println("FileReader and FileWriter : " + (finishTime - startTime));

        fileInput = new File("src/com/maks/IO/task3/files/bufferedFileInput");
        fileOutput = new File("src/com/maks/IO/task3/files/bufferedFileOutput");

        startTime = System.nanoTime();
        CopyFileToFile.copyBufferedFile(fileInput, fileOutput);
        finishTime = System.nanoTime();
        System.out.println("BufferReader and BufferWriter : " + (finishTime - startTime));

        //task4
        final File directory = new File("src/com/maks/IO/task4/dir");
        ViewingDirectory.printDir(directory);

        //task5
        List<Staff> staffList = new ArrayList<>();
        staffList.add(new Staff("Nick", "Jonson", 777));
        staffList.add(new Staff("Ron", "Gen", 8888));
        staffList.add(new Staff("Misha", "Pupkin", 99999));
        Report.generateReport(staffList);

        fileOutput = new File("src/com/maks/IO/task5/files/fileStaff");
        Report.createFileStaff(staffList, fileOutput);


    }

}
