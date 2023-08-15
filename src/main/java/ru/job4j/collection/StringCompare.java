package ru.job4j.collection;

public class StringCompare {
    public int compare(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() - 1 || j < s2.length() - 1) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return Character.compare(s1.charAt(i), s2.charAt(j));
            }
            i++;
            j++;
        }
        return Integer.compare(s1.length(), s2.length());

    }
}