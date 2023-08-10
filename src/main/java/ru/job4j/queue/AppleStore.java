package ru.job4j.queue;

import java.util.Iterator;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i <= count; i++) {
            if (i == count) {
                return queue.poll().name();
            }
            queue.remove();
        }
        return "";
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i <= count; i++) {
            if (i == count) {
                return queue.poll().name();
            }
            queue.remove();
        }
        return "";
    }
}