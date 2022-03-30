package com.company.validators;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$");

    public static boolean validName(String name) {

        return name != null;
    }

    public static boolean validFirstMenu(String choose) {
        return choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("Q");
    }

    public static boolean validSecondMenu(String choose) {
        return validFirstMenu(choose) || choose.equals("4");
    }

    public static boolean createMenuValidator(String choose) {
        return validFirstMenu(choose) || choose.equals("S");
    }

    public static boolean validPhoneNumber(String number) {
        if (number.charAt(0) == '+') {
            number = number.substring(1);
        }
        return number.matches(PHONE_NUMBER_PATTERN.pattern());
    }

    public static boolean validEmail(String email) {
        return email.matches(EMAIL_PATTERN.pattern());
    }
}