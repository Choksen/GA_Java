package com.maks.IO.task5;

import java.io.*;
import java.util.List;

public class Report {
    public static void generateReport(final List<Staff> staffList) {
        final PrintWriter writer = new PrintWriter(System.out);
        for (final Staff employee : staffList) {
            System.out.format("%s %s - salary %d \n",
                    employee.getName(),
                    employee.getSurname(),
                    employee.getSalary());
        }
    }

    public static void createFileStaff(final List<Staff> staffList, final File fileOutput) {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))) {
            String fullEmployee;
            for (final Staff employee : staffList) {
                fullEmployee = String.format("%s %s - salary %d \n",
                        employee.getName(),
                        employee.getSurname(),
                        employee.getSalary());
                writer.write(fullEmployee);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
