package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String regex = "[^0-9]";
        String[] splitLeft = left.split(regex);
        String[] splitRight = right.split(regex);
        Integer intLeft = Integer.parseInt(splitLeft[0]);
        Integer intRight = Integer.parseInt(splitRight[0]);
        return intLeft.compareTo(intRight);
    }
}