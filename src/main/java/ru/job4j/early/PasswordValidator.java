package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasValidLength = password.length() >= 8 && password.length() <= 32;
        for (char symbol : password.toCharArray()) {
            if (!hasUpCase) {
                hasUpCase = Character.isUpperCase(symbol);
            }
            if (!hasLowCase) {
                hasLowCase = Character.isLowerCase(symbol);
            }
            if (!hasDigit) {
                hasDigit = Character.isDigit(symbol);
            }
            if (!hasSpecial) {
                hasSpecial = !(Character.isLetter(symbol) || Character.isDigit(symbol));
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (!hasValidLength) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }
        for (String string : FORBIDDEN) {
            if (password.toLowerCase().contains(string)) {
                throw new IllegalArgumentException(
                        "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
                );
            }
        }
        return password;
    }
}