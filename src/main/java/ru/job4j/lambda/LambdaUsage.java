package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            int compare = Integer.compare(right.length(), left.length());
            System.out.println("result: " + compare);
            return compare;
        };
        strings.sort(comparator);
        System.out.println();
        for (String str : strings) {
            System.out.println(str);
        }
    }
}