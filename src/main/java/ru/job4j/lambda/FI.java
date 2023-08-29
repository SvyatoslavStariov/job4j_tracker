package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);
    }

    public static List<String> comparatorText(List<String> strings) {
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        strings.sort(cmpText);
        return strings;
    }

    public static List<String> comparatorDescSize(List<String> strings) {
        Comparator<String> cmpText = (left, right) -> Integer.compare(right.length(), left.length());
        strings.sort(cmpText);
        return strings;
    }
}