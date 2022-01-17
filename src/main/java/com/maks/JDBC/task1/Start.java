package com.maks.JDBC.task1;

import com.maks.JDBC.task1.controller.Controller;
import com.maks.JDBC.task1.domain.Person;

import java.sql.SQLException;
import java.util.List;

public class Start {
    public static void main(final String[] args) throws SQLException, IllegalArgumentException {
        Controller.createData();
        System.out.println();

        System.out.println("Person with min length letter : " + Controller.findPersonByMinLengthLetter());
        System.out.println();

        final List<Person> persons = Controller.personsInfo();
        for (final Person person : persons) {
            System.out.println(person.toString() +
                    " Number of emails sent : " +
                    Controller.countOfLettersSend(person) +
                    " Number of received emails: " +
                    Controller.countOfLettersReceived(person));
        }
        System.out.println();

        final String requiredHeader = "New Year";
        final List<Person> recipients = Controller.personHavingTopic(requiredHeader);
        System.out.println("People who received a letter with the title " + requiredHeader);
        for (final Person recipient : recipients) {
            System.out.println(recipient.getName() + " id:" + recipient.getId());
        }
        System.out.println();

        final List<Person> recipientsWithoutTopic = Controller.personDontHaveTopic(requiredHeader);
        System.out.println("People who did not receive a letter with the title " + requiredHeader);
        for (final Person recipient : recipientsWithoutTopic) {
            System.out.println(recipient.getName() + " id:" + recipient.getId());
        }
        System.out.println();

        final String topic = "Birthday";
        final int senderId = 3;
        Controller.sendLetterEveryone(senderId, topic);
        System.out.println();

    }
}
