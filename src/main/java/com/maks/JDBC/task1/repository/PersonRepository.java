package com.maks.JDBC.task1.repository;

import com.maks.JDBC.task1.domain.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository {
    Person savePerson(Person person) throws SQLException;

    Person findPersonById(long id);

    Integer findPersonByMinLengthLetter();

    List<Person> getAllPersons();

    Integer findCountOfLetterSend(Person person);

    Integer findCountOfLettersReceived(Person person);

    List<Person> getRecipientByTopicLetter(String topic);

    List<Person> getRecipientWithoutTopic(String topic);
}
