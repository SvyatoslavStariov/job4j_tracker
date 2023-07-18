package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Едем");
    }

    @Override
    public void passengers(int amount) {
        System.out.printf("Количество оставшихся мест: %s", 40 - amount);
    }

    @Override
    public int fuel(int amount) {
        return amount * 50;
    }
}
