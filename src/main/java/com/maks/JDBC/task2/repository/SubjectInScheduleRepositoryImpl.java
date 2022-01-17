package com.maks.JDBC.task2.repository;

import com.maks.JDBC.DriverManager;
import com.maks.JDBC.task2.domain.SubjectInSchedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectInScheduleRepositoryImpl implements SubjectInScheduleRepository {
    @Override
    public SubjectInSchedule save(final SubjectInSchedule subjectInSchedule) throws SQLException {
        final SubjectInSchedule savedSubjectInSchedule = new SubjectInSchedule(); //---
        final String request = "INSERT INTO schedule (teacher_subject, day, time) VALUES (?,?,?)";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, subjectInSchedule.getTeacherWithSubject());
            preparedStatement.setString(2, subjectInSchedule.getDay());
            preparedStatement.setInt(3, subjectInSchedule.getTime());

            preparedStatement.executeUpdate();

            try (final ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    savedSubjectInSchedule.setTeacherWithSubject(subjectInSchedule.getTeacherWithSubject());
                    savedSubjectInSchedule.setDay(subjectInSchedule.getDay());
                    savedSubjectInSchedule.setTime(subjectInSchedule.getTime());
                    savedSubjectInSchedule.setId(generatedKeys.getInt("id"));
                }
            }
        }
        return savedSubjectInSchedule;
    }

    @Override
    public List<String> getDaysByCountSubject(final Integer specifiedCount) {
        final List<String> matchingDays = new ArrayList<>();
        final String request = "SELECT s.day,COUNT(*) AS CNT FROM schedule s GROUP BY day HAVING COUNT(*)=?;";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setInt(1, specifiedCount);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                matchingDays.add(resultSet.getString("day"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return matchingDays;
    }

    @Override
    public List<String> getDaysByCountAuditorium(final Integer specifiedCount) {
        final List<String> matchingDays = new ArrayList<>();
        final String request = "SELECT s.day,COUNT(DISTINCT auditorium) AS count_auditorium FROM schedule s " +
                "INNER JOIN teacher t on t.id = s.teacher_subject " +
                "INNER JOIN subject s2 on s2.id = t.subject " +
                "group by s.day HAVING COUNT(DISTINCT auditorium) = ?;";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setInt(1, specifiedCount);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                matchingDays.add(resultSet.getString("day"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return matchingDays;
    }

    @Override
    public void transferFirstSubjectByDay(final String day) {
        final String request = "UPDATE schedule SET time = (" +
                "SELECT MAX(time)FROM schedule s2 WHERE s2.day = ?) + 1 " +
                "WHERE day = ? AND time = (" +
                "SELECT MIN(s3.time) FROM schedule s3 " +
                "WHERE s3.day = ?);";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setString(1, day);
            preparedStatement.setString(2, day);
            preparedStatement.setString(3, day);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
