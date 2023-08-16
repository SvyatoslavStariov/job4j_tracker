package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    private static final String REGEX = "[^0-9]";

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split(REGEX);
        String[] splitRight = right.split(REGEX);
        Integer intLeft = Integer.parseInt(splitLeft[0]);
        Integer intRight = Integer.parseInt(splitRight[0]);
        return intLeft.compareTo(intRight);
    }
}