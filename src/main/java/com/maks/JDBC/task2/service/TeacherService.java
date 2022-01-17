package com.maks.JDBC.task2.service;

import com.maks.JDBC.task2.domain.Teacher;
import com.maks.JDBC.task2.repository.TeacherRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TeacherService {
    private static final TeacherRepositoryImpl teacherRep = new TeacherRepositoryImpl();

    public static Teacher createTeacher(final Teacher teacher) {
        Teacher savedTeacher = null;
        try {
            savedTeacher = teacherRep.save(teacher);
        } catch (NullPointerException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return savedTeacher;
    }

    public static List<Teacher> getTeachersByDayAndAuditorium(final String requiredDay, final Integer requiredAuditorium) {
        if (requiredDay.isEmpty() || requiredAuditorium == null) {
            System.err.println("it is impossible to find a teacher, check the correctness of the entered data");
        }
        return teacherRep.getTeachersByDayAndAuditorium(requiredDay, requiredAuditorium);
    }

    public static List<Teacher> getTeachersNotWorkingOnDAy(final String requiredDay) {
        if (requiredDay.isEmpty()) {
            System.err.println("it is impossible to find a teacher, check the correctness of the entered data");
        }
        return teacherRep.getTeachersNotWorkingOnDAy(requiredDay);
    }
}
