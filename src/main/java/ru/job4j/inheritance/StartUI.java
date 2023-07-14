package ru.job4j.inheritance;

import ru.job4j.tracker.Item;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(dateTimeFormatter.format(new Item().getCreated()));
    }
}
