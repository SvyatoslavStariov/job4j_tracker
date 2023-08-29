package ru.job4j.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FITest {
    @Test
    public void comparatorTextTest() {
        List<String> input = Arrays.asList("a", "n", "c", "b");
        List<String> expect = Arrays.asList("a", "b", "c", "n");
        List<String> result = FI.comparatorText(input);
        assertThat(result).containsSequence(expect);
    }

    @Test
    public void comparatorDescSizeTest() {
        List<String> input = Arrays.asList("ssn", "bddd", "sa", "dc");
        List<String> expect = Arrays.asList("bddd", "ssn", "sa", "dc");
        List<String> result = FI.comparatorDescSize(input);
        assertThat(result).containsSequence(expect);
    }
}