package com.maks.JDBC.task1.repository;

import com.maks.JDBC.DriverManager;
import com.maks.JDBC.task1.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Person savePerson(final Person person) throws SQLException {
        final Person savedPerson = new Person();
        final String request = "INSERT INTO people (name, birthday) VALUES (?,?)";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, (Date) person.getBirthday());

            preparedStatement.executeUpdate();

            try (final ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    savedPerson.setName(person.getName());
                    savedPerson.setBirthday(person.getBirthday());
                    savedPerson.setId(generatedKeys.getInt("id"));
                }
            }
        }
        return savedPerson;
    }


    @Override
    public Person findPersonById(final long id) {
        final List<Person> personList = getAllPersons();
        for (final Person person : personList) {
            if (id == person.getId()) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Integer findPersonByMinLengthLetter() {
        int idPersonWithMinLengthLetter = 0;
        final String request = "SELECT DISTINCT sender FROM letters where length(text) = (SELECT min(length(text))FROM letters)";

        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                idPersonWithMinLengthLetter = resultSet.getInt("sender");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idPersonWithMinLengthLetter;
    }

    @Override
    public List<Person> getAllPersons() {
        final List<Person> personsList = new ArrayList<>();
        final String request = "SELECT * FROM people";

        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request)) {

            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personsList.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("birthday")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personsList;
    }

    @Override
    public Integer findCountOfLetterSend(final Person person) {
        int countLetter = 0;
        final String request = "SELECT sender, COUNT(*) AS CNT FROM letters" +
                " GROUP BY sender " +
                "HAVING sender = ?";

        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request)) {

            preparedStatement.setInt(1, person.getId());
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                countLetter = resultSet.getInt("CNT");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return countLetter;
    }

    @Override
    public Integer findCountOfLettersReceived(final Person person) {
        int countLetter = 0;
        final String request = "SELECT recipient, COUNT(*) AS CNT FROM letters" +
                " GROUP BY recipient " +
                "HAVING recipient = ?";

        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request)) {

            preparedStatement.setInt(1, person.getId());
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                countLetter = resultSet.getInt("CNT");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return countLetter;
    }

    @Override
    public List<Person> getRecipientByTopicLetter(final String topic) {
        final List<Person> matchingRecipient = new ArrayList<>();
        final String request = "SELECT DISTINCT p.* FROM people p " +
                "INNER JOIN letters l ON p.id = l.recipient " +
                "WHERE topic = ?";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setString(1, topic);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                matchingRecipient.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("birthday")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return matchingRecipient;
    }

    @Override
    public List<Person> getRecipientWithoutTopic(final String topic) {
        final List<Person> matchingRecipient = new ArrayList<>();
        final String request = "SELECT * FROM people p WHERE p.id NOT IN( " +
                "SELECT p2.id FROM  people p2 INNER JOIN letters l on p2.id = l.recipient " +
                "WHERE topic= ?);";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request);) {

            preparedStatement.setString(1, topic);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                matchingRecipient.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("birthday")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return matchingRecipient;
    }
}
