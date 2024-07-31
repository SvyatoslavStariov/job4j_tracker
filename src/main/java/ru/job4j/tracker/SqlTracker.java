package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
            .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
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

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET id = ?, name = ? WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM items WHERE items.id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = createItem(resultSet);
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items WHERE items.name = ?")) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = createItem(resultSet);
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items WHERE items.id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createItem(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Item createItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setName(resultSet.getString("name"));
        item.setId(resultSet.getInt("id"));
        item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
        return item;
    }
}