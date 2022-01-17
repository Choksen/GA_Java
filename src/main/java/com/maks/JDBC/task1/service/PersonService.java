package com.maks.JDBC.task1.service;

import com.maks.JDBC.task1.domain.Person;
import com.maks.JDBC.task1.repository.PersonRepositoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonService {
    private static final PersonRepositoryImpl personRep = new PersonRepositoryImpl();

    public static Person createPerson(final Person person) {
        Person savedPerson = null;
        try {
            savedPerson = personRep.savePerson(person);
        } catch (NullPointerException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return savedPerson;
    }


    public static int findPersonByMinLengthLetter() {
        return personRep.findPersonByMinLengthLetter();
    }

    public static List<Person> getAllPersons() {
        return personRep.getAllPersons();
    }

    public static Person findPersonById(final Integer id) {
        Person person = null;
        try {
            person = personRep.findPersonById(id);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return person;
    }

    public static Integer countOfLetterSend(final Person person) {
        Integer countOfLetterSend = null;
        try {
            countOfLetterSend = personRep.findCountOfLetterSend(person);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return countOfLetterSend;
    }

    public static Integer countOfLettersReceived(final Person person) {
        Integer countOfLettersReceived = null;
        try {
            countOfLettersReceived = personRep.findCountOfLettersReceived(person);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return countOfLettersReceived;
    }

    public static List<Person> personHavingTopic(final String topic) {
        if (topic.isEmpty()) {
            System.err.println("Empty topic");
        }
        final List<Person> recipients = personRep.getRecipientByTopicLetter(topic);
        if (recipients.isEmpty()) {
            System.err.println("No matches found");
        }
        return recipients;
    }

    public static List<Person> personDontHavingTopic(final String topic) {
        if (topic.isEmpty()) {
            System.err.println("Empty topic");
        }
        final List<Person> recipients = personRep.getRecipientWithoutTopic(topic);
        if (recipients.isEmpty()) {
            System.err.println("No matches found");
        }
        return recipients;
    }

    public static List<Integer> getAllPersonId() {
        final List<Integer> personIdList = new ArrayList<>();
        final List<Person> personList = personRep.getAllPersons();
        for (final Person person : personList) {
            personIdList.add(person.getId());
        }
        return personIdList;
    }
}
