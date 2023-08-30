package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    private final static String REGEX = "/";

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split(REGEX);
        String[] splitRight = right.split(REGEX);
        int result = splitRight[0].compareTo(splitLeft[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}