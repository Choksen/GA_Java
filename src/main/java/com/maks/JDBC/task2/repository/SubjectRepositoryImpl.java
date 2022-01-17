package com.maks.JDBC.task2.repository;

import com.maks.JDBC.DriverManager;
import com.maks.JDBC.task2.domain.Subject;

import java.sql.*;

public class SubjectRepositoryImpl implements SubjectRepository {

    @Override
    public Subject save(final Subject subject) throws SQLException {
        final Subject savedSubject = new Subject(); //---
        final String request = "INSERT INTO subject (name, count_students, auditorium) VALUES (?,?,?)";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getCount_students());
            preparedStatement.setInt(3, subject.getAuditorium());

            preparedStatement.executeUpdate();

            try (final ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    savedSubject.setName(subject.getName());
                    savedSubject.setCount_students(subject.getCount_students());
                    savedSubject.setAuditorium(subject.getAuditorium());
                    savedSubject.setId(generatedKeys.getInt("id"));
                }
            }
        }
        return savedSubject;
    }
}
