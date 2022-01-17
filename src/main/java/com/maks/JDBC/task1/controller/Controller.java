package com.maks.JDBC.task1.controller;

import com.maks.JDBC.task1.domain.Letter;
import com.maks.JDBC.task1.domain.Person;
import com.maks.JDBC.task1.service.LetterService;
import com.maks.JDBC.task1.service.PersonService;

import java.sql.Date;
import java.util.List;

public class Controller {

    public static void createData() {
        Person person = new Person("Grisha Pypkin", Date.valueOf("2001-01-01"));
        final Person person1 = PersonService.createPerson(person);
        person = new Person("Misha Ivanov", Date.valueOf("2001-12-10"));
        final Person person2 = PersonService.createPerson(person);
        person = new Person("Pasha Kirillov", Date.valueOf("2004-05-07"));
        final Person person3 = PersonService.createPerson(person);
        person = new Person("Maksim Ivanov", Date.valueOf("1999-12-10"));
        final Person person4 = PersonService.createPerson(person);
        person = new Person("Vova Egorov", Date.valueOf("2000-10-30"));
        final Person person5 = PersonService.createPerson(person);


        final Letter letter1 = new Letter("New Year", "Happy New Year", person1.getId(), person2.getId());
        LetterService.saveLetter(letter1);
        final Letter letter2 = new Letter("New Year", "Happy New Year my friend", person1.getId(), person4.getId());
        LetterService.saveLetter(letter2);
        final Letter letter3 = new Letter("Birthday", "I wish you a happy birthday", person4.getId(), person3.getId());
        LetterService.saveLetter(letter3);
        final Letter letter4 = new Letter("Family", "Luke I'm your father", person3.getId(), person2.getId());
        LetterService.saveLetter(letter4);
        final Letter letter5 = new Letter("Country house", "The flowers wilted", person3.getId(), person1.getId());
        LetterService.saveLetter(letter5);
        final Letter letter6 = new Letter("Family", "Luke I'm your father", person2.getId(), person5.getId());
        LetterService.saveLetter(letter6);
        final Letter letter7 = new Letter("Country house", "The garden gnomes were stolen", person5.getId(), person1.getId());
        LetterService.saveLetter(letter7);
    }

    public static Person findPersonByMinLengthLetter() {
        return PersonService.findPersonById(PersonService.findPersonByMinLengthLetter());
    }

    public static List<Person> personsInfo() {
        return PersonService.getAllPersons();
    }

    public static Integer countOfLettersSend(final Person person) {
        return PersonService.countOfLetterSend(person);
    }

    public static Integer countOfLettersReceived(final Person person) {
        return PersonService.countOfLettersReceived(person);
    }

    public static List<Person> personHavingTopic(final String topic) {
        return PersonService.personHavingTopic(topic);
    }

    public static List<Person> personDontHaveTopic(final String topic) {
        return PersonService.personDontHavingTopic(topic);
    }

    public static void sendLetterEveryone(final Integer senderId, final String topic) {
        LetterService.sendLetterEveryone(senderId, topic);
    }

}
