package com.maks.JDBC.task2.repository;

import com.maks.JDBC.DriverManager;
import com.maks.JDBC.task2.domain.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public Teacher save(final Teacher teacher) throws SQLException {
        final Teacher savedTeacher = new Teacher();//---
        final String request = "INSERT INTO teacher (name, subject, count_subject) VALUES (?,?,?)";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setInt(2, teacher.getSubject());
            preparedStatement.setInt(3, teacher.getCountSubjects());

            preparedStatement.executeUpdate();

            try (final ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    savedTeacher.setName(teacher.getName());
                    savedTeacher.setSubject(teacher.getSubject());
                    savedTeacher.setCountSubjects(teacher.getCountSubjects());
                    savedTeacher.setId(generatedKeys.getInt("id"));
                }
            }
        }
        return savedTeacher;
    }

    @Override
    public List<Teacher> getTeachersByDayAndAuditorium(final String requiredDay, final Integer requiredAuditorium) {
        final List<Teacher> matchingTeachers = new ArrayList<>();
        final String request = "SELECT DISTINCT t.* FROM schedule s " +
                "INNER JOIN teacher t ON s.teacher_subject = t.id " +
                "INNER JOIN subject s2 on t.subject = s2.id " +
                "WHERE s.day=? AND s2.auditorium=?";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setString(1, requiredDay);
            preparedStatement.setInt(2, requiredAuditorium);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                matchingTeachers.add(new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("subject"),
                        resultSet.getInt("count_subject")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return matchingTeachers;
    }

    @Override
    public List<Teacher> getTeachersNotWorkingOnDAy(final String requiredDay) {
        final List<Teacher> matchingTeachers = new ArrayList<>();
        final String request = "SELECT * FROM teacher t WHERE t.id NOT IN(" +
                "SELECT t2.id FROM teacher t2 " +
                "INNER JOIN schedule s on t2.id = s.teacher_subject " +
                "WHERE s.day = ?);";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setString(1, requiredDay);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                matchingTeachers.add(new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("subject"),
                        resultSet.getInt("count_subject")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return matchingTeachers;
    }
}
