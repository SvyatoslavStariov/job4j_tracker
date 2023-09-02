package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(sum);
    }
}