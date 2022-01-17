package com.maks.JDBC.task2;


import com.maks.JDBC.task2.controller.Controller;
import com.maks.JDBC.task2.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class StartTask2 {

    public static void main(final String[] args) {
        Controller.createData();

        final String requiredDay = "Tuesday";
        final Integer requiredAuditorium = 28;
        final List<Teacher> requiredTeachers = Controller.getTeachersByDayAndAuditorium(requiredDay, requiredAuditorium);
        System.out.println("Teachers who work on " + requiredDay + " in the classroom number " + requiredAuditorium);
        if (requiredTeachers.isEmpty()) {
            System.out.println("There are no matched teachers");
        }
        for (final Teacher teacher : requiredTeachers) {
            System.out.println(teacher.getName() + " id: " + teacher.getId());
        }
        System.out.println();

        requiredTeachers.clear();
        requiredTeachers.addAll(Controller.getTeachersNotWorkingOnDAy(requiredDay));
        System.out.println("Teachers who do not teach the subject on " + requiredDay + " :");
        if (requiredTeachers.isEmpty()) {
            System.out.println("There are no matched teachers");
        }
        for (final Teacher teacher : requiredTeachers) {
            System.out.println(teacher.getName() + " id: " + teacher.getId());
        }
        System.out.println();

        final Integer specifiedCount = 3;
        final List<String> matchedDays = Controller.getDaysByCountSubject(specifiedCount);
        System.out.println("days of the week on which " + specifiedCount + " subjects are held");
        if (matchedDays.isEmpty()) {
            System.out.println("There are no matched days");
        }
        for (final String day : matchedDays) {
            System.out.println(day);
        }
        System.out.println();

        matchedDays.clear();
        matchedDays.addAll(Controller.getDaysByCountAuditorium(specifiedCount));
        System.out.println("Days in which " + specifiedCount + " classrooms are occupied");
        if (matchedDays.isEmpty()) {
            System.out.println("There are no matched days");
        }
        for (final String day : matchedDays) {
            System.out.println(day);
        }
        System.out.println();

        final List<String> daysToTransfer = new ArrayList<>();
        daysToTransfer.add("Friday");
        daysToTransfer.add("Monday");
        System.out.println("Schedule update");
        Controller.transferFirstSubjectByDays(daysToTransfer);
    }
}
