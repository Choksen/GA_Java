package com.maks.JDBC.task1.service;

import com.maks.JDBC.task1.domain.Letter;
import com.maks.JDBC.task1.repository.LetterRepositoryImpl;

import java.util.List;


public class LetterService {
    private static final LetterRepositoryImpl letterRep = new LetterRepositoryImpl();

    public static Letter saveLetter(final Letter letter1) {
        Letter savedLetter = new Letter();
        try {
            savedLetter = letterRep.saveLetter(letter1);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return savedLetter;
    }

    public static void sendLetterEveryone(final Integer senderId, final String topic) {
        final List<Integer> personsId = PersonService.getAllPersonId();
        try {
            letterRep.sendLetterEveryone(personsId, senderId, topic);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
