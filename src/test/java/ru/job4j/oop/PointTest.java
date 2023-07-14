package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    public void when422and242then2dot8() {
        Point a = new Point(4, 2, 2);
        Point b = new Point(2, 4, 2);
        double result = a.distance3d(b);
        double expected = 2.8;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }

    @Test
    public void when723and163then7dot2() {
        Point a = new Point(7, 2, 3);
        Point b = new Point(1, 6, 3);
        double result = a.distance3d(b);
        double expected = 7.2;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }

    @Test
    public void when436and273then5dot3() {
        Point a = new Point(4, 3, 6);
        Point b = new Point(2, 7, 3);
        double result = a.distance3d(b);
        double expected = 5.3;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }
}