package com.maks.JDBC.task2.service;

import com.maks.JDBC.task2.domain.SubjectInSchedule;
import com.maks.JDBC.task2.repository.SubjectInScheduleRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ScheduleService {
    private static final SubjectInScheduleRepositoryImpl subjectInScheduleRep = new SubjectInScheduleRepositoryImpl();

    public static SubjectInSchedule addSubjectToSchedule(final SubjectInSchedule subjectInSchedule) {
        SubjectInSchedule savedSubjectInSchedule = null;
        try {
            savedSubjectInSchedule = subjectInScheduleRep.save(subjectInSchedule);
        } catch (NullPointerException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return savedSubjectInSchedule;
    }

    public static List<String> getDaysByCountSubject(final Integer specifiedCount) {
        if (specifiedCount == null) {
            System.err.println("Check the correctness of the entered data");
        }
        return subjectInScheduleRep.getDaysByCountSubject(specifiedCount);
    }

    public static List<String> getDaysByCountAuditorium(final Integer specifiedCount) {
        if (specifiedCount == null) {
            System.err.println("Check the correctness of the entered data");
        }
        return subjectInScheduleRep.getDaysByCountAuditorium(specifiedCount);
    }

    public static void transferFirstSubjectByDay(final String day) {
        if(day.isEmpty()){
            System.err.println("Check the correctness of the entered data");
        }
        subjectInScheduleRep.transferFirstSubjectByDay(day);
    }
}
