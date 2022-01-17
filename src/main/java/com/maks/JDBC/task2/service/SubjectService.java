package com.maks.JDBC.task2.service;

import com.maks.JDBC.task2.domain.Subject;
import com.maks.JDBC.task2.repository.SubjectRepositoryImpl;

import java.sql.SQLException;

public class SubjectService {
    private static final SubjectRepositoryImpl subjectRep = new SubjectRepositoryImpl();

    public static Subject createSubject(final Subject subject) {
        Subject savedSubject = null;
        try {
            savedSubject = subjectRep.save(subject);
        } catch (NullPointerException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return savedSubject;
    }
}
