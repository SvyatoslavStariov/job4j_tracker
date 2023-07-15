package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[this.items.length];
        Item[] items = findAll();
        int count = 0;
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rsl[count++] = item;
            }
        }
        return Arrays.copyOf(rsl, count);
    }
}