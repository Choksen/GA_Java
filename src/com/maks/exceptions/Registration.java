package com.maks.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration {
    private static final String PATTERN = "[a-zA-Z_0-9]{1,20}";

    public static void main(String[] args) {
        final List<User> users = new ArrayList<>();
        final Scanner in = new Scanner(System.in);
        String login;
        String password;
        String confirmPassword;

        while (users.size() < 5) {
            System.out.println("Enter your login");
            login = in.nextLine();
            System.out.println("Enter your password");
            password = in.nextLine();
            System.out.println("Confirm password");
            confirmPassword = in.nextLine();

            if (isValidateData(login, password, confirmPassword)) {
                users.add(new User(login, password));
            }
        }
        for (User user : users) {
            System.out.println(user.toString());
        }
        in.close();
    }

    public static boolean isValidateData(final String login, final String password, final String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static void validateLogin(final String login) throws WrongLoginException {
        if (!Pattern.matches(PATTERN, login)) {
            throw new WrongLoginException("Login does not meet the conditions");
        }
    }

    public static void validatePassword(final String password, final String confirmPassword) throws WrongPasswordException {
        if (!(Pattern.matches(PATTERN, password) && password.equals(confirmPassword))) {
            throw new WrongPasswordException("The password does not meet the conditions");
        }
    }

}
