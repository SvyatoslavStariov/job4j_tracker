package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                config.getProperty("url"),
                config.getProperty("username"),
                config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndReplaceThenNameMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item addedItem = tracker.add(item);
        int id = addedItem.getId();
        Item updateItem = new Item("new item");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("new item");
    }

    @Test
    public void whenSaveItemAndDeleteThenFindByIdMustBeNull() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenSaveThreeItemsAndDeleteOneThenFindAllMustBeTwoItems() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findAll().size()).isEqualTo(2);
    }

    @Test
    public void whenSaveTwoItemsThenFindByAllMustBeEqualsTwoItems() {
        Store tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> result = tracker.findAll();
        List<Item> expected = List.of(first, second);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenSaveFiveItemsThenFindByNameMustBeEqualsSizeThree() {
        Store tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(first);
        tracker.add(second);
        tracker.add(first);
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }
}