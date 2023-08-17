package ru.job4j.collection;

public class StringCompare {
    public int compare(String s1, String s2) {
        int size = Math.min(s1.length(), s2.length());
        for (int i = 0; i < size; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return Character.compare(s1.charAt(i), s2.charAt(i));
            }
        }
        return Integer.compare(s1.length(), s2.length());
    }
}