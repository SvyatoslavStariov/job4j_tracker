package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    private final static String REGEX = "/";

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split(REGEX);
        String[] splitRight = right.split(REGEX);
        if (!splitLeft[0].equals(splitRight[0])) {
            return Character.compare(splitRight[0].charAt(splitRight[0].length() - 1), splitLeft[0].charAt(splitLeft[0].length() - 1));
        }
        int size = Math.min(splitLeft.length, splitRight.length);
        for (int i = 0; i < size; i++) {
            if (!splitLeft[i].equals(splitRight[i])) {
                if (splitLeft[i].charAt(splitLeft[i].length() - 1) != splitRight[i].charAt(splitRight[i].length() - 1)) {
                    return Character.compare(splitLeft[i].charAt(splitLeft[i].length() - 1), splitRight[i].charAt(splitRight[i].length() - 1));
                }
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}