package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * (x * x) + 1);
        List<Double> expected = Arrays.asList(51.0, 73.0, 99.0);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenConstantFunctionThenConstantResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(65.0, 129.0, 257.0);
        assertThat(result).containsAll(expected);
    }
}