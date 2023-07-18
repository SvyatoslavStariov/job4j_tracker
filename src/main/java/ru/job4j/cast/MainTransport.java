package ru.job4j.cast;

public class MainTransport {
    public static void main(String[] args) {
        Vehicle[] transports = {
                new Bus(),
                new Train(),
                new Airplane()
        };
        for (Vehicle transport : transports) {
            transport.move();
        }
    }
}
