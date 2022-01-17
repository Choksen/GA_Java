package com.maks.JDBC.task1.repository;

import com.maks.JDBC.task1.domain.Letter;

import java.util.List;

public interface LetterRepository {
    Letter saveLetter(Letter letter);

    void sendLetterEveryone(List<Integer> personsId, Integer senderId, String topic);
}
