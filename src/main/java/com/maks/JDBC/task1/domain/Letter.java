package com.maks.JDBC.task1.domain;

import java.sql.Date;

public class Letter {
    private int id;
    private String topic;
    private String text;
    private Date date;
    private Integer sender;
    private Integer recipient;

    public Letter(final String topic, final String text, final Integer sender, final Integer recipient) {
        this.topic = topic;
        this.text = text;
        //Так и не понял про localDate
        this.date = new Date(System.currentTimeMillis());
        this.sender = sender;
        this.recipient = recipient;
    }

    public Letter(final String topic, final Integer sender, final Integer recipient) {
        this.topic = topic;
        this.text = "empty message";
        this.date = new Date(System.currentTimeMillis());
        this.sender = sender;
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(final String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(final Integer sender) {
        this.sender = sender;
    }

    public Integer getRecipient() {
        return recipient;
    }

    public Letter() {
    }

    public void setRecipient(final Integer recipient) {
        this.recipient = recipient;
    }
}
