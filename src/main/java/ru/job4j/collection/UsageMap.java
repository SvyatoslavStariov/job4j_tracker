package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("starikov@yandex.ru", "Slava Starikov");
        for (String key : map.keySet()) {
            String fullName = map.get(key);
            System.out.printf("email: %s, full name: %s \n", key, fullName);
        }
    }
}
