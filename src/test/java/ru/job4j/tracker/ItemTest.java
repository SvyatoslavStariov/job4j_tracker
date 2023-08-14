package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void equalsComparatorAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Slava"));
        items.add(new Item("Petr"));
        items.add(new Item("Mary"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Mary"));
        expected.add(new Item("Petr"));
        expected.add(new Item("Slava"));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void equalsComparatorDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Mary"));
        items.add(new Item("Petr"));
        items.add(new Item("Slava"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Slava"));
        expected.add(new Item("Petr"));
        expected.add(new Item("Mary"));
        assertThat(items).isEqualTo(expected);
    }
}