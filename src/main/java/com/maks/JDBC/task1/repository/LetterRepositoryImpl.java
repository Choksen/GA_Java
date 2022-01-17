package com.maks.JDBC.task1.repository;

import com.maks.JDBC.DriverManager;
import com.maks.JDBC.task1.domain.Letter;
import com.maks.JDBC.task1.service.LetterService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LetterRepositoryImpl implements LetterRepository {

    @Override
    public Letter saveLetter(final Letter letter) {
        final Letter savedLetter = new Letter();
        final String request = "INSERT INTO letters (topic,text,date,sender,recipient) VALUES(?,?,?,?,?)";
        try (final Connection conn = DriverManager.getConnection();
             final PreparedStatement preparedStatement = conn.prepareStatement(request,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, letter.getTopic());
            preparedStatement.setString(2, letter.getText());
            preparedStatement.setDate(3, letter.getDate());
            preparedStatement.setInt(4, letter.getSender());
            preparedStatement.setInt(5, letter.getRecipient());

            preparedStatement.executeUpdate();
            try(final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();){
                if(generatedKeys.next()){
                    savedLetter.setId(generatedKeys.getInt("id"));
                    savedLetter.setTopic(letter.getTopic());
                    savedLetter.setText(letter.getText());
                    savedLetter.setDate(letter.getDate());
                    savedLetter.setSender(letter.getSender());
                    savedLetter.setRecipient(letter.getRecipient());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return savedLetter;
    }

    @Override
    public void sendLetterEveryone(final List<Integer> personsId, final Integer senderId, final String topic) {
        final List<Letter> letterList = new ArrayList<>();
        for (final Integer recipientId : personsId) {
            letterList.add(new Letter(topic, senderId, recipientId));
            LetterService.saveLetter(letterList.get(0));
            letterList.clear();
        }
    }

}
