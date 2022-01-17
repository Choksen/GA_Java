package com.maks.exceptions;

public class User {
    public String login;
    public String password;

    public User(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
